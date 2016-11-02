package youth.hong.biz.impl;

import java.util.Date;
import java.util.List;

import youth.hong.biz.DVDBiz;
import youth.hong.dao.DVDDao;
import youth.hong.dao.RecordDao;
import youth.hong.dao.impl.DVDDaoImpl;
import youth.hong.dao.impl.RecordDaoImpl;
import youth.hong.entity.DVD;
import youth.hong.entity.Record;

public class DVDBizImpl implements DVDBiz {
	
	private DVDDao dvdDao = null;
	private RecordDao recordDao = null;
	
	public DVDBizImpl() {
		dvdDao = new DVDDaoImpl();
		recordDao = new RecordDaoImpl();
	}

	@Override
	public boolean addDVD(DVD dvd) {
		return dvdDao.saveDVD(dvd);
	}

	@Override
	public boolean delDVD(int did) {
		return dvdDao.delDVD(did);
	}

	@Override
	public boolean modifyDVD(DVD dvd) {
		return dvdDao.updateDVD(dvd);
	}

	@Override
	public List<DVD> queryAllDVDs() {
		List<DVD> dvds = null;
		dvds = dvdDao.queryDVDs();
		return dvds;
	}

	@Override
	public List<DVD> ranking_top_five() {
		List<DVD> dvds = null;
		dvds = dvdDao.querySortDVByLimit(0, 5);
		return dvds;
	}

	@Override
	public List<DVD> queryDVDByName(String dname) {
		List<DVD> dvds = null;
		dvds = dvdDao.queryDVDsByName(dname);
		return dvds;
	}

	@Override
	public DVD queryDVDById(int did) {
		DVD dvd = dvdDao.queryDVDsById(did);
		return dvd;
	}

	@Override
	public int lendDVD(int did, int uid) {
		DVD dvd = dvdDao.queryDVDsById(did);
		if(dvd == null) {
			return -1;//表示不存在这个dvd
		} else {
			if(dvd.getStatus() == 0) {
				return 0;//表示不可借
			} else {
				dvd.setStatus(0);
				dvd.setDcount(dvd.getDcount() + 1);
				dvdDao.updateDVD(dvd);
				Record record = new Record(uid, did, new Date(), null);
				if(recordDao.saveRecord(record)){
					return 1;//借出成功
				} else {
					return -2;//借出失败
				}
				
			}
		}
	}

	@Override
	public int returnDVD(int rid) {
		Record record = recordDao.queryRecordById(rid);
		if(record == null) {
			return -1;//记录不存在
		} else {
			if(record.getReturnTime() != null) {
				return 0;//已归还
			} else {
				record.setReturnTime(new Date());
				boolean flag1 = recordDao.updateRecord(record);
				DVD dvd = dvdDao.queryDVDsById(record.getDid());
				dvd.setStatus(1);
				boolean flag2 = dvdDao.updateDVD(dvd);
				if(flag1 && flag2) {
					return 1;//归还成功
				} else {
					return -2;//归还失败
				}
			}
		}
	}

	@Override
	public List<DVD> canLendDVD() {
		
		return dvdDao.queryDVDsByStatus(0);
	}

	@Override
	public List<DVD> hasLendedDVD() {
		return dvdDao.queryDVDsByStatus(1);
	}

}
