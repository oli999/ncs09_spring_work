package com.gura.spring02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  @Controller 어노테이션
 *  - 해당 클래스가 Spring MVC  프로젝트에서 Controller 가 될수 있도록 한다.
 *  - component scan 을 통해서 spring bean container 에서 관리가 되는 
 *    bean 이 되어야 동작을 한다.  
 */
@Controller
public class HomeController {
	
	// /home.do  요청이 왔을때 요청을 처리하게 하는 @RequestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		//모델
		List<String> notice=new ArrayList<>();
		notice.add("감기조심");
		notice.add("코로나 조심");
		notice.add("다들 살아 남아요~");
		notice.add("어쩌구...");
		notice.add("저쩌구...");
		
		//모델을 request 에 담는다.
		request.setAttribute("notice", notice);
		
		/*
		 *  "home" 을 리턴해주면
		 *  
		 *  "/WEB-INF/views/"+"home"+".jsp" 와 같은 문자열이 만들어 지고
		 *  
		 *  /WEB-INF/views/home.jsp 페이지로 forward 이동 되어서 
		 *  
		 *  응답된다. 
		 */
		return "home";
	}
}



