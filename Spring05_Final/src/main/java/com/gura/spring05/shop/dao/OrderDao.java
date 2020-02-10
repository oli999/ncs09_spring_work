package com.gura.spring05.shop.dao;

import com.gura.spring05.shop.dto.OrderDto;

public interface OrderDao {
	//배송 정보를 추가하는 메소드
	public void addOrder(OrderDto dto);
}
