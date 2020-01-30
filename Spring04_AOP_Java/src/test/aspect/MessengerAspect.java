package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 *  1. 리턴 type 은 상관없다
	 *  2. 메소드 명이 send 로 시작하는 메소드
	 *  3. 메소드에 전달되는 인자도 상관 없다
	 *  
	 *  위의 3가지 조건을 모두 만족시키는 메소드에 아래의 aop 가 적용된다.
	 */
	@Around("execution(* send*(..))")
	public void around(ProceedingJoinPoint joinPoint) 
			throws Throwable {
		//aop 가 적용된 메소드 수행 직전
		System.out.println("-- 수행 이전 --");
		
		//aop 가 적용된 메소드에 전달된 인자를 Object[] 로 얻어낼수 있다. 
		Object[] args=joinPoint.getArgs();
		//반복문 돌면서 찾고 싶은 type  을 찾는다
		for(Object tmp:args) {
			if(tmp instanceof String) {//만일 String type 이면
				//원래 type 으로 casting
				String msg=(String)tmp;
				System.out.println("aop 에서 읽어낸 내용:"+msg);
				if(msg.contains("바보")) {
					System.out.println("바보라고 하기 없기!");
					return; //메소드를 여기서 종료 시킨다 
				}
			}
		}
		
		//aop 가 적용된 메소드 수행하고 리턴되는값 받아오기(void 면 null 이다)
		Object obj=joinPoint.proceed();
		
		//aop  가 적용된 메소드 리턴 직후 
		System.out.println("-- 수행 직후 --");
	}
}






