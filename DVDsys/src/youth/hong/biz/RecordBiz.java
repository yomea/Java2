package youth.hong.biz;

import java.util.List;

import youth.hong.entity.Record2;

public interface RecordBiz {
	public List<Record2> queryUserRecords(String uname);
	
	public List<Record2> queryDVDRecords(String dname);
	//�鿴ָ���û��ѹ黹��¼
	public List<Record2> queryHasReturnedRecords(String uname);
	//�鿴�û�δ�黹��¼
	public List<Record2> queryNoReturnedRecords(String uname);
	//�鿴���м�¼
	public List<Record2> queryAllRecords();
	
}
