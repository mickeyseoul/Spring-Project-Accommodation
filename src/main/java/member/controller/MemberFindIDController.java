package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberFindIDController {
	
	private final String command = "/findid.mem";
	private String getPage = "/findIdForm";
	private String getPage2 = "/findIdResult";
	
	@Autowired
	private MemberDao memberDao;
	
	//login.jsp 아이디/비번 찾기 버튼 클릭
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String form() {
		return getPage;
	}
	
	//findIdForm.jsp
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String find(MemberBean member, Model model) {
		
		MemberBean memberBean = memberDao.findId(member);
		
		if(memberBean == null) { //해당 정보가 없다면
			model.addAttribute("result", 0);
		}else { //해당 정보가 있다면
			model.addAttribute("result", 1);
			model.addAttribute("memberBean", memberBean);
		}
		
		return getPage2;
	}

}
