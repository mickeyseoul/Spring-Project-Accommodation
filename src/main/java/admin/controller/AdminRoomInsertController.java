package admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hotel.model.HotelBean;
import hotel.model.HotelDao;
import hotel.model.RoomBean;

@Controller
public class AdminRoomInsertController {
	
	private final String command = "/roomInsert.ad";
	private String getPage = "/roomInsertForm";
	private String gotoPage = "redirect:/roomList.ad";
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	ServletContext application;
	
	//hotelInsertForm.jsp 호텔 이름 클릭 => roomList.jsp iframe으로 조회
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String form(@RequestParam("num") String num, Model model) {
		
		//룸등록할 호텔을 선택했을 때
		HotelBean hotel = hotelDao.getHotelByNum(num);
		model.addAttribute("number", num);
		model.addAttribute("hotel", hotel);
		

		return getPage;
		
	}
	
	//roomList.jsp -> 룸등록 클릭
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String insert(RoomBean room) {
		
		//룸 인서트
		//System.out.println(hotel.getName());
		//System.out.println(hotel.getImage()); //파일 이름
		//System.out.println(hotel.getUpload()); //org.springframework.web.multipart.commons.CommonsMultipartFile@16a3fb64
		hotelDao.insertRoom(room);
		
		//호텔테이블 룸 갯수 +1
		hotelDao.addRoomkind(room.getHotelnum());
				
		//이미지 저장
		String path = application.getRealPath("/resources");
		//System.out.println(path); 
		//C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_Project_Accommodation\resoures
		MultipartFile multi = room.getUpload();
		File file = new File(path+"/"+multi.getOriginalFilename());
				
		try {
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return gotoPage+"?refresh=1&num="+room.getHotelnum();
	}

}
