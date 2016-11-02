package youth.hong.dao;

import java.util.List;

import youth.hong.entity.Record;
import youth.hong.entity.Record2;

public interface RecordDao {
	
	public Record queryRecordById(int id);
	
	public boolean saveRecord(Record record);
	
	public boolean updateRecord(Record record);
	
	public List<Record2> queryAllRecords();
	
	/**
	 * �鿴ĳ���û��Ľ軹��¼
	 * @param name
	 * @return
	 */
	public List<Record2> queryByUname(String name);
	
	/**
	 * �鿴ĳ��dvd�Ľ軹��¼
	 * @param name
	 * @return
	 */

	public List<Record2> queryByDname(String name);
	
	//�鿴�û��黹��¼���ѹ黹��δ�黹��flagΪtrue��ʾ�ѹ黹��false��ʾΪ�黹
	public List<Record2> queryUserRecordByReturnTime(boolean flag, String uname);
	
}
