package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
	public String getPwdHash(String inputId);
	public UsersDto getData(String id);
	public void updateProfile(UsersDto dto);
	public void updatePwd(UsersDto dto);
}
