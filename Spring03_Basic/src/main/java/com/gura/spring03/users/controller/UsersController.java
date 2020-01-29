package com.gura.spring03.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	@RequestMapping("/users/loginform")
	public String loginform() {
		//수행할 비즈니스 로직은 없다
		//request 영역에 담을 모델도 없다.
		
		//view page 의 정보만 단순히 리턴해 주는 경우도 있다.
		return "users/loginform";
	}
}






