package com.gura.spring05.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/*
 *  Exception 이 발생했을때 처리하는 컨트롤러 만들기
 *  
 *  - @ControllerAdvice 어노테이션을 클래스에 붙인다.
 *  
 *  - 메소드에 @ExceptionHandler(예외 class type) 을 붙여서 예외를 처리 한다. 
 */
@ControllerAdvice
public class ExceptionController {
	// CanNotDeleteException type 의 예외가 발생하면 호출되는 메소드 
	@ResponseStatus(HttpStatus.FORBIDDEN) //응답 상태를 표시 하고 싶으면 표시 한다
	@ExceptionHandler(CanNotDeleteException.class)
	public ModelAndView forbidden() {
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", "남의 파일 지우면 혼난다~");
		mView.setViewName("error/forbidden");
		return mView;
	}
	// custom 예외 처리 
	@ExceptionHandler(NoDeliveryException.class)
	public ModelAndView noDelivery(NoDeliveryException nde) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception", nde);
		mView.setViewName("error/data_access");
		return mView;
	}
	
	/*
	 *  @Repository 어노테이션이 작성된 Dao 에서 DB 관련 Exception 이 발생하면
	 *  Spring 프레임워크가 DataAccessException type 의 예외를 발생시킨다.
	 *  예외 객체는 메소드의 인자로 전달되고 해당 예외 객체는 getMessage() 라는 
	 *  getter 메소드가 존재한다. 
	 *  해당 메소드를 호출하면 예외 메세지를 리턴해준다.
	 */
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView dataAccess(DataAccessException dae) {
		ModelAndView mView=new ModelAndView();
		// "exception" 이라는 키값으로 예외 객체를 담는다. 
		mView.addObject("exception", dae);
		//  view page 설정 
		mView.setViewName("error/data_access");
		return mView;
	}
}










