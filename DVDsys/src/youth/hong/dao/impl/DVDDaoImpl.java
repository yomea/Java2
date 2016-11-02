package youth.hong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import youth.hong.dao.DVDDao;
import youth.hong.entity.DVD;

public class DVDDaoImpl extends BaseDao implements DVDDao {

	@Override
	public boolean saveDVD(DVD dvd) {
		String sql = "insert into dvds(dname, dcount, status) values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(dvd.getDname());
		params.add(dvd.getDcount());
		params.add(dvd.getStatus());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateDVD(DVD dvd) {
		String sql = "update dvds set dname=?, dcount=?, status=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dvd.getDname());
		params.add(dvd.getDcount());
		params.add(dvd.getStatus());
		params.add(dvd.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delDVD(int did) {
		String sql = "delete from dvds where id=?";
		return this.operUpdate(sql, null);
	}

	@Override
	public List<DVD> queryDVDs() {
		List<DVD> dvds = new ArrayList<DVD>();
		String sql = "select id, dname, dcount, status from dvds";
		dvds = this.operQuery(sql, null, DVD.class);
		return dvds;
	}

	@Override
	public List<DVD> queryDVDsByName(String dname) {
		List<DVD> dvds = new ArrayList<DVD>();
		String sql = "select id, dname, dcount, status from dvds where dname=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dname);
		dvds = this.operQuery(sql, params, DVD.class);
		return dvds;
	}

	@Override
	public List<DVD> querySortDVByLimit(int index, int number) {
		List<DVD> dvds = new ArrayList<DVD>();
		String sql = "select id, dname, dcount, status from dvds order by dcount desc limit ?,?";
		List<Object> params = new ArrayList<Object>();
		params.add(index);
		params.add(number);
		dvds = this.operQuery(sql, params, DVD.class);
		return dvds;
	}

	@Override
	public DVD queryDVDsById(int id) {
		List<DVD> dvds = new ArrayList<DVD>();
		String sql = "select id, dname, dcount, status from dvds where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		dvds = this.operQuery(sql, params, DVD.class);
		if(dvds.size() > 0) {
			return dvds.get(0);
		} else{
			return null;
		}
	}

	@Override
	public List<DVD> queryDVDsByStatus(int status) {
		List<DVD> dvds = new ArrayList<DVD>();
		String sql = "select id, dname, dcount, status from dvds where status=?";
		List<Object> params = new ArrayList<Object>();
		params.add(status);
		dvds = this.operQuery(sql, params, DVD.class);
		return dvds;
	}

}
