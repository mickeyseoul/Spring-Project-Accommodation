package hotel.model;

import org.springframework.web.multipart.MultipartFile;

public class HotelBean {
	private String num;		
	private String name;					
	private String area1;
	private String area2;
	private String roomkind; //룸 종류 갯수 추가
	private String image;						
	private String star;		
	private String heart;
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getRoomkind() {
		return roomkind;
	}
	public void setRoomkind(String roomkind) {
		this.roomkind = roomkind;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	
	


	/* 이미지 등록 */
	private MultipartFile upload;

	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		this.image = upload.getOriginalFilename(); //진짜 이미지 이름
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
