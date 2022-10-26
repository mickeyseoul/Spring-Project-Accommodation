package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {
	
	private final String command = "/update.mem";
	private String getPage = "/updateForm";
	private String gotoPage = "redirect:/list.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String update(@RequestParam("num") String num, Model model) {
		
		//System.out.println("num "+num);
		MemberBean member = memberDao.getMemberByNum(num);
		
		model.addAttribute("member",member);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String update(MemberBean member, Model model) {
		
		System.out.println("member.getNum() "+member.getNum());
		memberDao.updateMember(member);
		
		return gotoPage;
	}

}
