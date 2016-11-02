package youth.hong.service;

import javax.annotation.Resource;

import youth.hong.dao.Dao;
import youth.hong.entity.User;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Resource(name="daoImpl")
	private Dao dao;
	
	@Override
	public void add(User user) {
		dao.add(user);
	}

}
