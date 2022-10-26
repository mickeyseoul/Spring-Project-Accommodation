package admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.model.HotelBean;
import hotel.model.HotelDao;
import hotel.model.RoomBean;

@Controller
public class AdminHotelDeleteController {
	
	private final String command = "/deleteHotel";
	private String gotoPage = "redirect:/insert.ad";
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping(command)
	public String delete(@RequestParam("num") String num) {
		
		//이미지 삭제
		String path = application.getRealPath("/resources");
		
		HotelBean hotel = hotelDao.getHotelByNum(num);
		File hotelImgFile = new File(path+"/"+hotel.getImage());
		hotelImgFile.delete();
		
		List<RoomBean> lists = new ArrayList<RoomBean>();
		lists = hotelDao.getRoomByHotelnum(num);
		for(RoomBean x : lists) {
			File roomImgFile = new File(path+"/"+x.getImage());
			roomImgFile.delete();
		}
		
		
		//호텔 삭제
		hotelDao.deleteHotel(num);
		
		//삭제할 호텔에 해당하는 룸도 삭제
		hotelDao.deleteRoomByHotelnum(num);
		
		return gotoPage;
	}

}
