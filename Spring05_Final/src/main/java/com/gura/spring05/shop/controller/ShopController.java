package com.gura.spring05.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService service;
	
	@RequestMapping("/shop/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("shop/list");
		return mView;
	}
	@RequestMapping("/shop/buy")
	public ModelAndView authBuy(HttpServletRequest request,
			ModelAndView mView) {
		service.buy(request, mView);
		mView.setViewName("shop/buy");
		return mView;
	}
}












