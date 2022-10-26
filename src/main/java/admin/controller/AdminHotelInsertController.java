package admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@Controller
public class AdminHotelInsertController {
	
	private final String command = "/insert.ad";
	private String getPage = "/hotelInsertForm";
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	ServletContext application;
	
	//관리자 메인 -> 상품 등록 버튼
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String form(Model model) {
		
		//호텔 리스트 조회
		List<HotelBean> lists = new ArrayList<HotelBean>();
		lists = hotelDao.getAllHotel();
		
		model.addAttribute("lists", lists);
		
		return getPage;

	}
	
	
	//hotelInsertForm.jsp -> 등록 버튼
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String insert(HotelBean hotel, Model model) {
		
		//호텔 인서트
		//System.out.println(hotel.getName());
		//System.out.println(hotel.getImage()); //파일 이름
		//System.out.println(hotel.getUpload()); //org.springframework.web.multipart.commons.CommonsMultipartFile@16a3fb64
		hotelDao.insertHotel(hotel);
		
		//이미지 저장
		String path = application.getRealPath("/resources");
		//System.out.println(path); 
		//C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_Project_Accommodation\resoures
		MultipartFile multi = hotel.getUpload();
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
		
		//호텔 리스트 조회
		List<HotelBean> lists = new ArrayList<HotelBean>();
		lists = hotelDao.getAllHotel();
		
		model.addAttribute("lists", lists);
		
		return getPage;
	}

}























