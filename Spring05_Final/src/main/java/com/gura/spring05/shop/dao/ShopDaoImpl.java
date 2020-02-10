package com.gura.spring05.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.shop.dto.ShopDto;

@Repository
public class ShopDaoImpl implements ShopDao{
	//의존 객체
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ShopDto> getList() {
		return session.selectList("shop.getList");
	}

	@Override
	public void minusCount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minusMoney(ShopDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void plusPoint(ShopDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPrice(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
