package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	
	private final String command = "/login.mem";
	private String getPage = "/login";
	private String gotoPage = "redirect:/main.mall";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String login() {
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String login(MemberBean member, Model model, HttpSession session) {
		
		int result = memberDao.loginIdCheck(member);
		//System.out.println("result "+result);
		
		if(result == 0) { //1 가입한 아이디가 없다면
			model.addAttribute("loginCheck", -1);
			return getPage;
			
		}else { //2 가입한 아이디가 있다면
			int loginCheck = memberDao.login(member);
			//System.out.println("loginCheck "+loginCheck);
			
			if(loginCheck == 0) { //2-1 비번이 일치하지 않다면
				model.addAttribute("loginCheck", -2);
				return getPage;
				
			}else { //2-2 비번이 일치한다면
				session.setAttribute("loginInfo", member);
				if(member.getId().equals("admin")) { //관리자
					return "redirect:/main.ad";
				}
				return gotoPage;
			}
			
		}//
		
	}

}
