package hotel.model;

import org.springframework.web.multipart.MultipartFile;

public class RoomBean {
	private String num;
	private String hotelnum;		
	private String name;												
	private String price;			
	private String point;		
	private String qty;
	private String brief;	
	private String content;		
	private String image;
	private String people;
	private String smoke;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getHotelnum() {
		return hotelnum;
	}
	public void setHotelnum(String hotelnum) {
		this.hotelnum = hotelnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	
	/* 이미지 등록 */
	private MultipartFile upload;

	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		this.image = upload.getOriginalFilename();
	}
	
	
	

}
