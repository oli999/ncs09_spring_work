package com.gura.spring05.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dto.MemberDto;

public interface MemberService {
	public void getList(ModelAndView mView);
	public void addMember(MemberDto dto);
	public void getMember(ModelAndView mView, int num);
	public void updateMember(MemberDto dto);
	public void deleteMember(int num);
}







