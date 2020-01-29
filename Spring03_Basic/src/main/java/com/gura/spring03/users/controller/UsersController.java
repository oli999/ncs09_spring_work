package com.gura.spring03.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	
	//로그인 폼 요청 처리 
	@RequestMapping("/users/loginform")
	public String loginform() {
		//수행할 비즈니스 로직은 없다
		//request 영역에 담을 모델도 없다.
		
		//view page 의 정보만 단순히 리턴해 주는 경우도 있다.
		return "users/loginform";
	}
	//로그인 요청 처리
	@RequestMapping("/users/login")
	public String login(HttpServletRequest request, 
				HttpSession session) {
		//폼 전송되는 파라미터를  추출한다. 
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//유효한 정보인지 여부
		boolean isSuccess=false;
		if(id.equals("gura") && pwd.equals("1234")) {
			isSuccess=true;
			//로그인 처리를 한다
			session.setAttribute("id", id);
		}
		//로그인 성공 여부를 request 에 담는다.
		request.setAttribute("isSuccess", isSuccess);
		//view page 의 정보를 리턴한다.
		return "users/login";
	}
	/*
	 *  @RequestParam 어노테이션은 전송되는 파라미터를 자동으로 추출할때 사용한다.
	 *  단, 지역 변수의 이름은 파라미터의 이름과 같아야 한다. 
	 */
	@RequestMapping("/users/login2")
	public ModelAndView login2(@RequestParam String id, 
			@RequestParam String pwd, HttpSession session,
			ModelAndView mView) {
		//유효한 정보인지 여부
		boolean isSuccess=false;
		if(id.equals("gura") && pwd.equals("1234")) {
			isSuccess=true;
			//로그인 처리를 한다
			session.setAttribute("id", id);
		}
		//view 페이지에서 필요한 모델을 담고 
		mView.addObject("isSuccess", isSuccess);
		//view page 의 정보도 담고 
		mView.setViewName("users/login");
		//리턴해 준다. 
		return mView;
	}
}













