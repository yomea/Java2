package youth.hong.dao;

import org.apache.ibatis.annotations.Param;

import youth.hong.entity.SuccessSeckill;

public interface SuccessSeckillDao {
	/**
	 * 插入购买明细，可过滤重复
	 * @param secillId
	 * @param userPhone
	 * @return
	 */
	public int insertSuccessKill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
	
	public SuccessSeckill queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
}
