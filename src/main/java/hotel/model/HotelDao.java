package hotel.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hotelDao")
public class HotelDao {
	
	private String namespace = "hotel.model.HotelDao";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<HotelBean> getAllHotel() {
		List<HotelBean> list = new ArrayList<HotelBean>();
		list = sqlSessionTemplate.selectList(namespace+".GetAllHotel", list);
		return list;
	}
	
	//호텔 등록
	public void insertHotel(HotelBean hotel) {
		sqlSessionTemplate.insert(namespace+".InsertHotel", hotel);
		
	}

	public HotelBean getHotelByNum(String num) {
		HotelBean hotel = sqlSessionTemplate.selectOne(namespace+".GetHotelByNum", num);
		return hotel;
	}

	public void deleteHotel(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteHotel", num);
		
	}
	
	//룸 등록
	public void insertRoom(RoomBean room) {
		System.out.println(room.getName());
		System.out.println(room.getPrice());
		System.out.println(room.getPoint());
		System.out.println(room.getSmoke());
		sqlSessionTemplate.insert(namespace+".InsertRoom", room);
		
	}

	public void addRoomkind(String hotelnum) {
		sqlSessionTemplate.update(namespace+".AddRoomkind", hotelnum);
		
	}
	
	public void minusRoomkind(String hotelnum) {
		sqlSessionTemplate.update(namespace+".MinusRoomkind", hotelnum);
		
	}

	public List<RoomBean> getRoomByHotelnum(String num) {
		List<RoomBean> lists = new ArrayList<RoomBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetRoomByHotelnum", num);
		return lists;
	}

	public void deleteRoom(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteRoom", num);
		
	}

	public void deleteRoomByHotelnum(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteRoomByHotelnum", num);
		
	}

	public RoomBean getRoomByNum(String num) {
		RoomBean room = sqlSessionTemplate.selectOne(namespace+".GetRoomByNum", num);
		return room;
	}

	

}
