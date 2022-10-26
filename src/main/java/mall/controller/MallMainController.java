package mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MallMainController {
	
	private final String command = "/main.mall";
	private String getPage = "/main";
	
	@RequestMapping(command)
	public String main() {
		return getPage;
	}

}
