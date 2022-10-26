package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	
	private final String command = "/register.mem";
	private String getPage = "/registerForm";
	private String gotoPage = "redirect:/list.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	//메인 -> 회원가입 버튼
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String register() {
		return getPage;
	}
	
	//register.jsp -> submit 버튼
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String register(@Valid MemberBean member, BindingResult result) { //command 객체 //유효성 검사
		
		if(result.hasErrors()) {
			return getPage;
		}

		memberDao.registerMember(member);
		
		return gotoPage;
	}
	//유효성검사
	//command 객체 -> setter 통한 bean 주입을 자동으로 해줌
	//@ModelAttribute("별칭") @Valid BookBean bbean도 가능
	//객체를 만들때 정보가 result로 들어감
	//command 객체 바로 옆에 BindingResult result 써야 함, 한칸 뛰면 에러

}

