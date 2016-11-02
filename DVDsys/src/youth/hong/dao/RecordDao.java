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
	 * 查看某个用户的借还记录
	 * @param name
	 * @return
	 */
	public List<Record2> queryByUname(String name);
	
	/**
	 * 查看某个dvd的借还记录
	 * @param name
	 * @return
	 */

	public List<Record2> queryByDname(String name);
	
	//查看用户归还记录（已归还，未归还）flag为true表示已归还，false表示为归还
	public List<Record2> queryUserRecordByReturnTime(boolean flag, String uname);
	
}
