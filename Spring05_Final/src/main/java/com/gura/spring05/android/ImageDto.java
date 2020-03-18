package com.gura.spring05.android;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {
	private int num;
	private String writer;
	private String imagePath;
	private String regdate;
	private MultipartFile myFile;
	public ImageDto() {}
	public ImageDto(int num, String writer, String imagePath, String regdate, MultipartFile myFile) {
		super();
		this.num = num;
		this.writer = writer;
		this.imagePath = imagePath;
		this.regdate = regdate;
		this.myFile = myFile;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public MultipartFile getMyFile() {
		return myFile;
	}
	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	
}
