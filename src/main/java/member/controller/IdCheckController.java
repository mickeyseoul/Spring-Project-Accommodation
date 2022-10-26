package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.model.MemberDao;

@Controller
public class IdCheckController {
	
	private final String command = "id_check_proc.mem";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(command)
	@ResponseBody //ajax를 통해 왔다면..
	public String check(@RequestParam("inputid") String inputid) {
		
		System.out.println(inputid);
		
		int cnt = -1;
		cnt = memberDao.checkDuplId(inputid);
		if(cnt == 0){
			return "can"; // .jsp가 아닌 단순 문자열 리턴 -> 'data'로 보냄
		}else {
			return "cannot";
		}
	}

}

