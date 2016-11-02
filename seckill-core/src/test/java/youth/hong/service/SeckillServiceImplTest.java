package youth.hong.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import youth.hong.dto.Exposer;
import youth.hong.dto.SeckillExcution;
import youth.hong.entity.Seckill;
import youth.hong.exception.RepeatSecKillException;
import youth.hong.exception.SecKillOverException;
import youth.hong.exception.SeckillException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml", "classpath:spring-service.xml" })
public class SeckillServiceImplTest {
	// this.getClass应用了反射，得到类名
	// INFO youth.hong.service.SeckillServiceImplTest - seckillInfo=Seckill
	// [seckillId=1000, name=iPhone, number=193, startTiem=Fri Jan 01 08:00:00
	// CST 2016, endTime=Sat Jan 02 08:00:00 CST 2016, createTime=Thu Jul 07
	// 00:50:01 CST 2016]
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@Test
	public void getSeckillListTest() {
		List<Seckill> seckills = seckillService.getSeckillList();
		for (Seckill seckill : seckills) {
			logger.info("seckillInfo={}", seckill);
		}
	}

	@Test
	public void getByIdTest() {
		long seckillId = 1000L;
		Seckill seckill = seckillService.getById(seckillId);
		logger.info("seckill={}", seckill);
	}

	/**
	 * INFO youth.hong.service.SeckillServiceImplTest - exposer=Exposer
	 * [exposed=true, md5=3351a06268b4aa20ab1ebfe5d3befc53, seckillId=1003,
	 * now=0, start=0, end=0]
	 */
	@Test
	public void SeckillTest() {
		long seckillId = 1003L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if (exposer.isExposed()) {
			try {
				long userPhone = 15970935811L;
				String md5 = "3351a06268b4aa20ab1ebfe5d3befc53";
				SeckillExcution seckillExcution = seckillService.executeSeckill(seckillId, userPhone, md5);
				logger.info("seckillExcution={}", seckillExcution);

			} catch (RepeatSecKillException e) {
				logger.error(e.getMessage());
			} catch (SecKillOverException e) {
				logger.error(e.getMessage());
			} catch (SeckillException e) {
				logger.error(e.getMessage());
			}
		} else {

			logger.warn("exposer={}", exposer);
		}
	}

}
