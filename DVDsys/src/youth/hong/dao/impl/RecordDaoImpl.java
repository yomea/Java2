package youth.hong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import youth.hong.dao.RecordDao;
import youth.hong.entity.Record;
import youth.hong.entity.Record2;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	@Override
	public Record queryRecordById(int id) {
		List<Record> records = null;
		String sql = "select id, uid, did, lendTime, returnTime from records where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		records = this.operQuery(sql, params, Record.class);
		if (records.size() > 0) {
			return records.get(0);
		} else {

			return null;
		}
	}

	@Override
	public boolean saveRecord(Record record) {
		String sql = "insert into records(uid, did, lendTime, returnTime values(?,?,?,?))";
		List<Object> params = new ArrayList<Object>();
		params.add(record.getUid());
		params.add(record.getDid());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateRecord(Record record) {
		String sql = "update records set uid=?,did=?,lendTime=?,returnTime=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(record.getUid());
		params.add(record.getDid());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		params.add(record.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Record2> queryAllRecords() {
		List<Record2> records = null;
		String sql = "select r.id as id, d.id as did, u.uname as uname, d.dname as dname, "
				+ "lendTime, returnTime from records r, users u, dvds d where u.id=r.uid and d.id=r.did";
		records = this.operQuery(sql, null, Record2.class);

		return records;
	}

	@Override
	public List<Record2> queryByUname(String name) {
		List<Record2> records = null;
		// 其实也不必这样各个设置别名，只需要给d.id设置一下就可以了，自动会忽略前面那个别名
		String sql = "select r.id as id, d.id as did, u.uname as uname, d.dname as dname, "
				+ "lendTime, returnTime from records r, users u, dvds d where u.id=r.uid and d.id=r.did and u.uname = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		records = this.operQuery(sql, params, Record2.class);

		return records;
	}

	@Override
	public List<Record2> queryByDname(String name) {
		List<Record2> records = null;
		// 其实也不必这样各个设置别名，只需要给d.id设置一下就可以了，自动会忽略前面那个别名
		String sql = "select r.id as id, d.id as did, u.uname as uname, d.dname as dname, "
				+ "lendTime, returnTime from records r, users u, dvds d where u.id=r.uid and d.id=r.did and d.dname = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		records = this.operQuery(sql, params, Record2.class);

		return records;
	}

	@Override
	public List<Record2> queryUserRecordByReturnTime(boolean flag, String uname) {
		String sql = "";
		List<Record2> records = null;
		if (flag) {
			sql = "select r.id as id, d.id as did, u.uname as uname, d.dname as dname, "
					+ "lendTime, returnTime from records r, users u, dvds d where u.id=r.uid and d.id=r.did and returnTime is not null and uname=?";
		} else {
			sql = "select r.id as id, d.id as did, u.uname as uname, d.dname as dname, "
					+ "lendTime, returnTime from records r, users u, dvds d where u.id=r.uid and d.id=r.did and returnTime is null and uname=?";
		}
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		records = this.operQuery(sql, params, Record2.class);

		return records;
	}

}
