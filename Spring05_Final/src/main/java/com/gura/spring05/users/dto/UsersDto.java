package com.gura.spring05.users.dto;

public class UsersDto {
	private String id;
	private String pwd;
	private String email;
	private String regdate;
	private String profile; //프로필 이미지 경로를 저장할 필드
	private String newPwd; //새로운 비밀번호를 저장할 필드
	
	public UsersDto() {}

	public UsersDto(String id, String pwd, String email, String regdate, String profile, String newPwd) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.regdate = regdate;
		this.profile = profile;
		this.newPwd = newPwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
}






