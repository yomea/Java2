package youth.hong.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import youth.hong.entity.SuccessSeckill;

/**
 * spring与junit整合
 * 
 * @author May
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SuccessSeckillDaoTest {
	
	@Resource
	SuccessSeckillDao successSeckillDao;

	@Test
	public void insertSuccessKill() {
		long seckillId = 1001L;
		long userPhone = 15179237204L;
		int insertCount = successSeckillDao.insertSuccessKill(seckillId, userPhone);
		System.out.println("插入的行数：" + insertCount);
		
	}

	@Test
	public void queryByIdWithSeckill() {
		SuccessSeckill successSeckill = successSeckillDao.queryByIdWithSeckill(1001L, 15179237204L);
		System.out.println(successSeckill.getSeckill());
	}

}
