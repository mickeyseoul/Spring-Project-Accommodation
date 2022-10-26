package admin.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.model.HotelDao;
import hotel.model.RoomBean;

@Controller
public class AdminRoomDeleteController {
	
	private final String command = "/deleteRoom.ad";
	private String gotoPage = "redirect:/roomList.ad";
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") String num, @RequestParam("hotelnum") String hotelnum) {
		
		//등록된 이미지 삭제
		RoomBean room = hotelDao.getRoomByNum(num);
		String path = application.getRealPath("/resources");
		File delFile = new File(path+"/"+room.getImage());
		delFile.delete();
		
		hotelDao.deleteRoom(num);
		hotelDao.minusRoomkind(hotelnum);
		
		
		return gotoPage+"?refresh=1&num=0";
	}

}
