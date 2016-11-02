package youth.hong.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import youth.hong.dao.SeckillDao;
import youth.hong.dao.SuccessSeckillDao;
import youth.hong.dao.cache.RedisDao;
import youth.hong.dto.Exposer;
import youth.hong.dto.SeckillExcution;
import youth.hong.entity.Seckill;
import youth.hong.entity.SuccessSeckill;
import youth.hong.enums.SeckillStateEnum;
import youth.hong.exception.RepeatSecKillException;
import youth.hong.exception.SecKillOverException;
import youth.hong.exception.SeckillException;

/**
 * 实现SeckillService接口
 * 
 * @author May
 *
 */
// @Component, @Serivce,@Dao，@Controll

@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisDao redisDao;

	@Autowired
	private SeckillDao seckillDao;

	@Autowired
	private SuccessSeckillDao successSeckillDao;

	private String salt = "asdcnf38423shfUOY*&YF8E7438*&9*w";

	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		// 优化操作
		Seckill seckill = redisDao.getSeckill(seckillId);
		if (seckill == null) {
			seckill = seckillDao.queryById(seckillId);
			if (seckill == null) {
				return new Exposer(false, seckillId);
			} else {
				redisDao.putSeckill(seckill);

			}
		}
		long startTime = seckill.getStartTiem().getTime();
		long endTime = seckill.getEndTime().getTime();
		long currentTime = new Date().getTime();

		if (currentTime < startTime || currentTime > endTime) {
			return new Exposer(false, seckillId, currentTime, startTime, endTime);
		}
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	@Transactional
	/**
	 * 使用注解配置事务的方法的优点： 1：开发团队达成一致的约定，明确标注事务方法的编程风格
	 * 2：保证事务方法的执行时间尽可能短，不要穿插网络操作如：RPC/HTTP，如果必须要，那么应当放到事务配置外面
	 * 3：不是所有的方法的都需要事务操作，像只读的操作就不需要事务
	 */
	public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatSecKillException, SecKillOverException {

		try {

			if (md5 != null && md5.equals(this.getMD5(seckillId))) {
				Date nowDate = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowDateStr = simpleDateFormat.format(nowDate);
				// 先写insert语句，再写update语句，降低网络延迟，出现问题可以直接rollback
				// 先update会抱着行级锁一直到commit或者rollback，应尽量缩短与commit的距离
				int insertCount = successSeckillDao.insertSuccessKill(seckillId, userPhone);

				if (insertCount <= 0) {
					throw new RepeatSecKillException("repeat seckill");
				} else {
					// 减库存
					int updateCount = seckillDao.reduceNumber(seckillId, nowDateStr);
					if (updateCount <= 0) {
						throw new SecKillOverException("seckill over");
					} else {

						SuccessSeckill successSeckill = successSeckillDao.queryByIdWithSeckill(seckillId, userPhone);
						return new SeckillExcution(seckillId, SeckillStateEnum.SUCCESS, successSeckill);

					}
				}

			} else {
				throw new SeckillException("seckill data is changed");
			}
		} catch (SecKillOverException e) {
			throw e;
		} catch (RepeatSecKillException e) {
			throw e;
		} catch (Exception e) {
			// 所有编译异常都转化为seckillException
			logger.error(e.getMessage(), e);
			throw new SeckillException("seckill inner error" + e.getMessage());
		}

	}

	public SeckillExcution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
		if(md5 == null || !md5.equals(this.getMD5(seckillId))) {
			return new SeckillExcution(seckillId, SeckillStateEnum.DATA_REWRITE);
		}
		Date date  = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sekillId", seckillId);
		map.put("userPhone", userPhone);
		map.put("killTime", date);
		map.put("state", null);
		try {
			seckillDao.killProcedure(map);
			int state = MapUtils.getInteger(map, "state", -2);
			if(state == 1) {
				SuccessSeckill successSeckill = successSeckillDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExcution(seckillId, SeckillStateEnum.SUCCESS,successSeckill);
			} else {
				return new SeckillExcution(seckillId, SeckillStateEnum.stateOf(state));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR);
		}
	}

}
