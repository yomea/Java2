package youth.hong.dao;

import org.springframework.stereotype.Repository;

import youth.hong.entity.User;

@Repository
public class DaoImpl implements Dao {

	@Override
	public void add(User user) {
		System.out.println("add success!!!");
		
	}

}
