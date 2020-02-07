package com.gura.spring05.aspect;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAspect {
	
	@Around("execution(org.springframework.web.servlet.ModelAndView auth*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop 가 적용된 메소드에 전달된 값을 Object[] 로 얻어오기
		Object[] args=joinPoint.getArgs();
		//로그인 여부
		boolean isLogin=false;
		HttpServletRequest request=null;
		for(Object tmp:args) {
			//인자로 전달된 값중에 HttpServletRequest type 을 찾아서
			if(tmp instanceof HttpServletRequest) {
				//원래 type 으로 casting
				request=(HttpServletRequest)tmp;
				//HttpSession 객체 얻어내기 
				HttpSession session=request.getSession();
				//세션에 "id" 라는 키값으로 저장된게 있는지 확인(로그인 여부)
				if(session.getAttribute("id") != null) {
					isLogin=true;
				}
			}
		}
		//로그인 했는지 여부
		if(isLogin){
			// aop 가 적용된 메소드를 실행하고 
			Object obj=joinPoint.proceed();
			// 리턴되는 값을 리턴해 주기 
			return obj;
		}
		//월래 가려던 url 정보 읽어오기 
		String url=request.getRequestURI();
		//GET 방식 전송 파라미터를 query string 으로 얻어오기
		String query=request.getQueryString();
		
		String encodedUrl=null;
		if(query==null) {//전달된 파라미터가 없다면 
			encodedUrl=URLEncoder.encode(url);
		}else {
			encodedUrl=URLEncoder.encode(url+"?"+query);
		}
		//ModelAndView 객체를 생성해서 	
		ModelAndView mView=new ModelAndView();
		//로그인 폼으로 리다일렉트 시키도록 view page 설정
		mView.setViewName
		("redirect:/users/loginform.do?url="+encodedUrl);
		
		//여기서 생성한 객체를 리턴해 준다. 
		return mView;		
	}
	
	@Around("execution(java.util.Map auth*(..))")
	public Object loginCheckAjax(ProceedingJoinPoint joinPoint) throws Throwable {
		//aop 가 적용된 메소드에 전달된 값을 Object[] 로 얻어오기
		Object[] args=joinPoint.getArgs();
		//로그인 여부
		boolean isLogin=false;
		HttpServletRequest request=null;
		for(Object tmp:args) {
			//인자로 전달된 값중에 HttpServletRequest type 을 찾아서
			if(tmp instanceof HttpServletRequest) {
				//원래 type 으로 casting
				request=(HttpServletRequest)tmp;
				//HttpSession 객체 얻어내기 
				HttpSession session=request.getSession();
				//세션에 "id" 라는 키값으로 저장된게 있는지 확인(로그인 여부)
				if(session.getAttribute("id") != null) {
					isLogin=true;
				}
			}
		}
		//로그인 했는지 여부
		if(isLogin){
			// aop 가 적용된 메소드를 실행하고 
			Object obj=joinPoint.proceed();
			// 리턴되는 값을 리턴해 주기 
			return obj;
		}
		//로그인을 하지 않았으면
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", false);
		return map;
	}	
}









