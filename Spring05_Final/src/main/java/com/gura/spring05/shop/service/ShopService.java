package com.gura.spring05.shop.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ShopService {
	public void getList(ModelAndView mView);
	public void buy(HttpServletRequest request, ModelAndView mView);
}
