package youth.hong.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import youth.hong.dao.SeckillDao;
import youth.hong.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class RedisDaoTest {
	
	private long seckillId = 1001L;
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private RedisDao redisDao;

	@Test
	public void test() {
		Seckill seckill = redisDao.getSeckill(seckillId);
		if(seckill == null) {
			seckill = seckillDao.queryById(seckillId);
			if(seckill != null) {
				String result = redisDao.putSeckill(seckill);
				
				System.out.println(result);
				
			}
			
		}
	}

}
