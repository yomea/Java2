package youth.hong.biz;

import java.util.List;

import youth.hong.entity.Record2;

public interface RecordBiz {
	public List<Record2> queryUserRecords(String uname);
	
	public List<Record2> queryDVDRecords(String dname);
	//查看指定用户已归还记录
	public List<Record2> queryHasReturnedRecords(String uname);
	//查看用户未归还记录
	public List<Record2> queryNoReturnedRecords(String uname);
	//查看所有记录
	public List<Record2> queryAllRecords();
	
}
