package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	//글목록 요청처리
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request){
		// HttpServletRequest 객체를 서비스에 넘겨 주면서
		// 비즈니스 로직을 수행하고 
		service.getList(request);
		
		// view page 로 forward 이동해서 글 목록 출력하기 
		return new ModelAndView("cafe/list");
	}	
}
