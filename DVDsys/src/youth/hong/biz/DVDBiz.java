package youth.hong.biz;

import java.util.List;

import youth.hong.entity.DVD;

public interface DVDBiz {
	public boolean addDVD(DVD dvd);//���DVD
	public boolean delDVD(int did);//ɾ��DVD
	public boolean modifyDVD(DVD dvd);//�޸�dvd
	public List<DVD> queryAllDVDs();//��ѯ���е�dvd
	public List<DVD> ranking_top_five();//top5
	public List<DVD> queryDVDByName(String dname);//����dvd����������ѯ
	public DVD queryDVDById(int did);//����id��ѯdvd
	public int lendDVD(int did, int uid);//��dvd��ź��û��������dvd
	public int returnDVD(int rid);//��dvd�Ĺ���
	public List<DVD> canLendDVD();//�ɽ�dvd
	public List<DVD> hasLendedDVD();//���ɽ�dvd
}
