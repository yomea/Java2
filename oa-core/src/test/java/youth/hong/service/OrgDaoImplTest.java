package youth.hong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;
import youth.hong.pager.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring-service.xml"})
public class OrgDaoImplTest {
	
	@Autowired
	private OrgService orgService;
	
	@Test
	public void addOrgnizationTest() {
		Org org = new Org("youth", "123456","闻明企业",0);
		
		orgService.addOrgnization(org);
	}
	
	@Test
	public void delOrgnizationTest() {
		
		orgService.delOrgnization(2);
	}
	
	@Test
	public void findOrgByIdTest() {
		
		Orgnization org = orgService.findOrgById(3);
		System.out.println(org);
		
	}
	
	@Test
	public void findTopOrgnizationTest() {
		
		Pager<Orgnization> orgs = orgService.findTopOrgnization(2, 5, 0);
		System.out.println(orgs.getData());
		System.out.println("CurrentPage:" + orgs.getCurrentPage());
		System.out.println("TotalPages:" + orgs.getTotalPages());
		System.out.println("TotalRecords:" + orgs.getTotalRecords());
		System.out.println("PageSize:" + orgs.getPageSize());
		
	}
	
	@Test
	public void findAllOrgnizationTest() {
		
		Pager<Orgnization> orgs = orgService.findAllOrgnization(1, 5);
		System.out.println(orgs.getData());
		System.out.println("CurrentPage:" + orgs.getCurrentPage());
		System.out.println("TotalPages:" + orgs.getTotalPages());
		System.out.println("TotalRecords:" + orgs.getTotalRecords());
		System.out.println("PageSize:" + orgs.getPageSize());
		
	}
	
	
}
