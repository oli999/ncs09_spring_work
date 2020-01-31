package com.gura.spring05.member.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존 객체 주입 받기(DI)
	@Autowired
	private MemberDao dao;
	
	// 회원 목록 보기 요청(/member/list.do) 을 처리할 컨트롤러의 메소드
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//회원 목록을 얻어오려면? 
		List<MemberDto> list=dao.getList();
		
		mView.addObject("list", list);
		mView.setViewName("member/list");
		return mView;
	}
	//회원정보 삭제 요청 처리
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		//MemberDao 객체를 이용해서 회원정보 삭제
		dao.delete(num);
		//리다일렉트 응답
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		//수행할 비즈니스 로직은 없다
		return "member/insertform";
	}
	/*
	 *  @ModelAttribute  MemberDto dto 를 메소드의 인자로 선언하면
	 *  폼 전송되는 파라미터가 자동으로 MemberDto 객체에 setter 메소드를 통해서
	 *  들어가고 그 객체가 메소드의 인자로 전달된다. 
	 *  단, 파라미터명과 Dto 의 필드명이 일치해야 된다.
	 */
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute("dto") MemberDto dto,
			ModelAndView mView) {
		dao.insert(dto);
		/*
		 *  @ModelAttribute("dto") MemberDto dto 의 의미는
		 *  1. 전송되는 파라미터를 자동으로 추출해서 MemberDto 에 담아 주기도하고
		 *  2. "dto" 라는 키값으로 MemberDto 객체를 request 영역에 담아주는
		 *     역활도 한다.
		 */
		//mView.addObject("dto", dto);
		mView.setViewName("member/insert");
		return mView;
	}
}















