package com.gura.spring05.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	//서비스는 Dao 에 의존한다. 
	@Autowired
	private MemberDao dao;
	
	//회원 목록을 인자로 전달 받은 ModelAndView 객체에 담는 로직을 처리하는 서비스 메소드 
	@Override
	public void getList(ModelAndView mView) {
		List<MemberDto> list=dao.getList();
		mView.addObject("list", list);
	}

}








