package youth.hong.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import youth.hong.entity.Seckill;

public interface SeckillDao {
	/**
	 * 减库存
	 * @param secillId
	 * @param killTime
	 * @return
	 */
	public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") String killTime);
	
	/**
	 * 通过id查询商品
	 * @param secillId
	 * @return
	 * @param注解是告诉mybatis有这样一个参数，因为在java中它对形参是不会保存的queryById（arg0,arg1）
	 */
	public Seckill queryById(long secillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	public void killProcedure(Map<String, Object> killMap);
	
}
