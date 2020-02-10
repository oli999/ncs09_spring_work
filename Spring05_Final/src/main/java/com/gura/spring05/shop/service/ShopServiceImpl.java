package com.gura.spring05.shop.service;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.exception.NoDeliveryException;
import com.gura.spring05.shop.dao.OrderDao;
import com.gura.spring05.shop.dao.ShopDao;
import com.gura.spring05.shop.dto.OrderDto;
import com.gura.spring05.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{
	//의존 객체
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	
	@Override
	public void getList(ModelAndView mView) {
		List<ShopDto> list=shopDao.getList();
		mView.addObject("list", list);
	}
	
	/*
	 *  - Spring 프레임워크에서 트렌젝션 설정 방법
	 *  1. pom.xml 에 spring-tx dependency  추가
	 *  2. servlet-context.xml 에 transaction 설정 추가
	 *  3. 트렌젝션을 적용할 서비스의 메소드에 @Transactional  어노테이션을 추가 한다.
	 */
	
	//상품 구입 처리를 하는 비즈니스 로직
	@Transactional
	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		//로그인된 아이디
		String id=(String)request.getSession().getAttribute("id");
		//구입할 상품 번호
		int num=Integer.parseInt(request.getParameter("num"));
		//1. 상품의 가격정보 얻어오기
		int price=shopDao.getPrice(num);
		//2. 상품의 가격만큼 계좌 잔액 줄이기
		ShopDto dto=new ShopDto();
		dto.setId(id);
		dto.setPrice(price);
		dto.setNum(num);
		shopDao.minusMoney(dto);
		//3. 가격의 10% 를 포인트로 적립
		shopDao.plusPoint(dto);
		//4. 재고의 갯수를 1 감소 시킨다.
		shopDao.minusCount(num);
		//5. 배송 요청 정보를 추가 한다.
		OrderDto dto2=new OrderDto();
		dto2.setId(id);
		dto2.setCode(num);
		dto2.setAddr("강남역 스타벅스");
		orderDao.addOrder(dto2);
	}

}




