package youth.hong.service;

import java.util.List;

import youth.hong.dto.Exposer;
import youth.hong.dto.SeckillExcution;
import youth.hong.entity.Seckill;
import youth.hong.exception.RepeatSecKillException;
import youth.hong.exception.SecKillOverException;
import youth.hong.exception.SeckillException;

/**
 * վ��ʹ���ߵĽǶ�ȥ��������
 * 
 * @author May
 *
 */
public interface SeckillService {
	/**
	 * ��ȡ������ɱ��¼
	 * 
	 * @return
	 */
	public List<Seckill> getSeckillList();

	/**
	 * ��ȡ������ɱ��¼
	 * 
	 * @param seckillId
	 * @return
	 */
	public Seckill getById(long seckillId);

	/**
	 * ������ɱ��url��ַ�� δ�����ͷ��ؿ�����ʱ���ϵͳʱ��
	 * 
	 * @param seckillId
	 */
	public Exposer exportSeckillUrl(long seckillId);

	/**
	 * ִ����ɱ����
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatSecKillException, SecKillOverException;
	
	/**
	 * ʹ�ô洢���̽����Ż�����
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	public SeckillExcution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
