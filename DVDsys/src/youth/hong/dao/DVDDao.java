package youth.hong.dao;

import java.util.List;

import youth.hong.entity.DVD;

public interface DVDDao {
	
	public boolean saveDVD(DVD dvd);
	
	public boolean updateDVD(DVD dvd);
	
	public boolean delDVD(int id);
	
	public List<DVD> queryDVDs();
	
	public List<DVD> queryDVDsByName(String name);
	
	public List<DVD> querySortDVByLimit(int index, int number);
	
	public DVD queryDVDsById(int id);
	
	public List<DVD> queryDVDsByStatus(int status);
}
