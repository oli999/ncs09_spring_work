package com.gura.spring05.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.shop.dao.OrderDao;
import com.gura.spring05.shop.dao.ShopDao;
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

	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		// TODO Auto-generated method stub
		
	}

}
