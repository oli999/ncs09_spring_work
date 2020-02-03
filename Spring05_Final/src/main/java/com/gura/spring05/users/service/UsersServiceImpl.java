package com.gura.spring05.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;
	//인자로 전달된 아이디가 존재하는지 여부를 Map 에 담아서 리턴하는 메소드 
	@Override
	public Map<String, Object> isExistId(String inputId) {
		boolean isExist=dao.isExist(inputId);
		Map<String, Object> map=new HashMap<>();
		map.put("isExist", isExist);
		return map;
	}
	@Override
	public void addUser(UsersDto dto) {
		//비밀번호를 암호화 한다.
		String encodedPwd=new BCryptPasswordEncoder().encode(dto.getPwd());
		//암호화된 비밀번호를 UsersDto 에 다시 넣어준다.
		dto.setPwd(encodedPwd);
		//UsersDao 객체를 이용해서 DB 에 저장하기 
		dao.insert(dto);
	}
	@Override
	public void validUser(UsersDto dto, HttpSession session, ModelAndView mView) {
		//아이디 비밀번호가 유효한지 여부 
		boolean isValid=false;
		//아이디를 이용해서 저장된 비밀 번호를 읽어온다. 
		String pwdHash=dao.getPwdHash(dto.getId());
		if(pwdHash != null) {//비밀번호가 존재하고 
			//입력한 비밀번호와 일치 하다면 로그인 성공
			isValid=BCrypt.checkpw(dto.getPwd(), pwdHash);
		}
		if(isValid) {
			//로그인 처리를 한다.
			session.setAttribute("id", dto.getId());
		}
	}

}
















