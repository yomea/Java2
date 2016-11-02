package youth.hong.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import youth.hong.entity.Seckill;

public interface SeckillDao {
	/**
	 * �����
	 * @param secillId
	 * @param killTime
	 * @return
	 */
	public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") String killTime);
	
	/**
	 * ͨ��id��ѯ��Ʒ
	 * @param secillId
	 * @return
	 * @paramע���Ǹ���mybatis������һ����������Ϊ��java�������β��ǲ��ᱣ���queryById��arg0,arg1��
	 */
	public Seckill queryById(long secillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	public void killProcedure(Map<String, Object> killMap);
	
}
