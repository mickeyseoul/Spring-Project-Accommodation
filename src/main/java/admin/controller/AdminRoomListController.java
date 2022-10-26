package admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.model.HotelBean;
import hotel.model.HotelDao;
import hotel.model.RoomBean;

@Controller
public class AdminRoomListController {
	private final String command = "/roomList.ad";
	private String getPage = "/roomList";
	
	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String list(@RequestParam("refresh") String refresh, @RequestParam("num") String num, Model model) {
		
		if(Integer.valueOf(refresh)==1) { //부모창 새로고침이 필요한 때
			 model.addAttribute("refresh", refresh);
		}
		
		//hotel의 num에 맞는 room 가져오기
		List<RoomBean> lists = new ArrayList<RoomBean>();
		lists = hotelDao.getRoomByHotelnum(num);
			 
		HotelBean hotel = hotelDao.getHotelByNum(num);
		model.addAttribute("number", num);
		model.addAttribute("hotel", hotel);
		model.addAttribute("lists", lists);

		return getPage;
	}

}
