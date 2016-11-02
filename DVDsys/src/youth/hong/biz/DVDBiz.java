package youth.hong.biz;

import java.util.List;

import youth.hong.entity.DVD;

public interface DVDBiz {
	public boolean addDVD(DVD dvd);//添加DVD
	public boolean delDVD(int did);//删除DVD
	public boolean modifyDVD(DVD dvd);//修改dvd
	public List<DVD> queryAllDVDs();//查询所有的dvd
	public List<DVD> ranking_top_five();//top5
	public List<DVD> queryDVDByName(String dname);//根据dvd的名字来查询
	public DVD queryDVDById(int did);//根据id查询dvd
	public int lendDVD(int did, int uid);//按dvd编号和用户编号来租dvd
	public int returnDVD(int rid);//还dvd的功能
	public List<DVD> canLendDVD();//可借dvd
	public List<DVD> hasLendedDVD();//不可借dvd
}
