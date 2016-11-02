package youth.hong.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;
import youth.hong.message.Message;
import youth.hong.pager.Pager;
import youth.hong.service.OrgService;
import youth.hong.util.PagerDisplay;

@Controller
@RequestMapping("/orgnization")
public class OrgnizationController {

	@Autowired
	private OrgService orgService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json; charset=utf-8" })
	@ResponseBody
	public Message addOrgnization(Org org) {
		boolean flag = orgService.addOrgnization(org);
		System.out.println(org.getPid());
		if (flag) {
			return new Message(flag);
		} else {
			return new Message(flag);
		}

	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "add_input";
	}
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager() {
		return "manager";
	}

	@RequestMapping(value = "/{id}/orgnization", method = RequestMethod.GET)
	public String finedOrgnizationById(@PathVariable("id") int id, Model model) {
		Orgnization orgnization = orgService.findOrgById(id);
		model.addAttribute("orgnization", orgnization);
		return "detail_orgnization";
	}

	@RequestMapping(value = "/topOrgs", method = RequestMethod.GET)
	public String topOrgs(Model model,  @RequestParam(defaultValue="0") int id) {
		Pager<Orgnization> pager = null;
		pager = PagerDisplay.getPager(orgService, 1, 5, id);
		model.addAttribute("pager", pager);
		model.addAttribute("id", id);
		int pid = 0;
		if(id != 0) {
			
			pid = orgService.getPid(id);
		}
		model.addAttribute("pid", pid);
		System.out.println(pid);
		return "index";
	}

	@RequestMapping(value = "/orgs", method = RequestMethod.GET, produces = { "application/json; charset=utf-8" })
	@ResponseBody
	public Pager<Orgnization> getOrgs(@RequestParam(defaultValue = "1") int currentPage,  @RequestParam(defaultValue="0") int id) {
		Pager<Orgnization> pager = null;
		pager = orgService.findTopOrgnization(currentPage, 5, id);
		System.out.println(pager.getData());
		return pager;
	}
	
	@RequestMapping(value="/del", method=RequestMethod.POST, produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Message delete(@RequestParam("id") int id) {
		int count = orgService.getTotalRecords(id);
		boolean success = false;
		System.out.println(count);
		if(count <= 0) {
			
			success = orgService.delOrgnization(id);
		} else {
			success = false;
		}
		return new Message(success);
	}

}
