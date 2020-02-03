package com.gura.spring05.users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	//회원가입 폼 요청 처리 
	@RequestMapping("/users/signup_form")
	public String signup_form() {
		return "users/signup_form";
	}
	/*
	 *  [ JSON 문자열 응답하는 방법 ]
	 *  1. pom.xml 에 jackson-databind dependency 명시
	 *  2. controller 의 메소드에 @ResponseBody 어노테이션 붙이기
	 *  3. List, Map, Dto 중에 하나를 리턴한다.
	 */
	@ResponseBody
	@RequestMapping("/users/checkid")
	public Map<String, Object> checkid(@RequestParam String inputId){
		Map<String, Object> map=service.isExistId(inputId);
		return map;
	}
}





