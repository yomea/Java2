package youth.hong.service;

import java.util.List;

import youth.hong.dto.Exposer;
import youth.hong.dto.SeckillExcution;
import youth.hong.entity.Seckill;
import youth.hong.exception.RepeatSecKillException;
import youth.hong.exception.SecKillOverException;
import youth.hong.exception.SeckillException;

/**
 * 站在使用者的角度去考虑问题
 * 
 * @author May
 *
 */
public interface SeckillService {
	/**
	 * 获取所有秒杀记录
	 * 
	 * @return
	 */
	public List<Seckill> getSeckillList();

	/**
	 * 获取单个秒杀记录
	 * 
	 * @param seckillId
	 * @return
	 */
	public Seckill getById(long seckillId);

	/**
	 * 开启秒杀的url地址， 未开启就返回开启的时间和系统时间
	 * 
	 * @param seckillId
	 */
	public Exposer exportSeckillUrl(long seckillId);

	/**
	 * 执行秒杀操作
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatSecKillException, SecKillOverException;
	
	/**
	 * 使用存储过程进行优化操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	public SeckillExcution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
