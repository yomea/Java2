package youth.hong.biz.impl;

import java.util.List;

import youth.hong.biz.RecordBiz;
import youth.hong.dao.RecordDao;
import youth.hong.dao.impl.RecordDaoImpl;
import youth.hong.entity.Record2;

public class RecordBizImpl implements RecordBiz {
	private RecordDao recordDao = null;
	
	public RecordBizImpl() {
		recordDao = new RecordDaoImpl();
	}

	@Override
	public List<Record2> queryUserRecords(String uname) {
		return recordDao.queryByUname(uname);
	}

	@Override
	public List<Record2> queryDVDRecords(String dname) {
		return recordDao.queryByDname(dname);
	}

	@Override
	public List<Record2> queryHasReturnedRecords(String uname) {
		return recordDao.queryUserRecordByReturnTime(true, uname);
	}

	@Override
	public List<Record2> queryNoReturnedRecords(String uname) {
		return recordDao.queryUserRecordByReturnTime(false, uname);
	}

	@Override
	public List<Record2> queryAllRecords() {
		return recordDao.queryAllRecords();
	}

}
