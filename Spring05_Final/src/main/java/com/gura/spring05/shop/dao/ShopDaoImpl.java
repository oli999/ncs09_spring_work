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
		//제고의 갯수 줄이기 
		session.update("shop.minusCount", num);
	}

	@Override
	public void minusMoney(ShopDto dto) {
		//계좌 잔액 줄이기
		session.update("shop.minusMoney", dto);
	}

	@Override
	public void plusPoint(ShopDto dto) {
		//보너스 포인트 쌓기
		session.update("shop.plusPoint", dto);
	}

	@Override
	public int getPrice(int num) {
		//가격 select 해서 리턴하기
		return session.selectOne("shop.getPrice", num);
	}

}
