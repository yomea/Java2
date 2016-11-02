package youth.hong.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import youth.hong.entity.Seckill;

/**
 * spring与junit整合,junit启动时加载spring的配置文件使用注入功能
 * 
 * @author May
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载配置文件
 * 
 * @author May
 *
 */
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class SeckillDaoTest {
	
	@Resource
	SeckillDao seckillDao;
	
	@Test
	public void testQueryAll() {
		List<Seckill> seckills = seckillDao.queryAll(0, 4);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
		
	}

	@Test
	public void queryById() {
		Seckill seckill = seckillDao.queryById(1000);
		System.out.println(seckill);
	}

	@Test
	public void reduceNumber() {
		/*SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = simpleDateFormat.parse("2016-01-01 01:01:01");
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		int updateCount = seckillDao.reduceNumber(1000L, "2016-01-01 01:01:01");
		System.out.println("影响的行数：" + updateCount);
	}

}
