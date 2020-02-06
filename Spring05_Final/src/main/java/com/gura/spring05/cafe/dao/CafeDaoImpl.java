package com.gura.spring05.cafe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeDaoImpl implements CafeDao{
	@Autowired
	private SqlSession session;
}
