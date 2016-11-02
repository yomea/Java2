package youth.hong.dao;

import org.apache.ibatis.annotations.Param;

import youth.hong.entity.SuccessSeckill;

public interface SuccessSeckillDao {
	/**
	 * ���빺����ϸ���ɹ����ظ�
	 * @param secillId
	 * @param userPhone
	 * @return
	 */
	public int insertSuccessKill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
	
	public SuccessSeckill queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
}
