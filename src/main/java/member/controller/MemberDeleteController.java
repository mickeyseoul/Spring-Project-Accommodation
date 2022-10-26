package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	
	private final String command = "/delete.mem";
	private String gotoPage = "redirect:/list.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") String num) {
		memberDao.deleteMember(num);
		return gotoPage;
	}

}
