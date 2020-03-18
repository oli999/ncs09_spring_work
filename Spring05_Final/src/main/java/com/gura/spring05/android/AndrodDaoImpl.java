package com.gura.spring05.android;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AndrodDaoImpl implements AndroidDao{
	@Autowired
	private SqlSession session;
	@Override
	public void insert(ImageDto dto) {
		session.insert("android.insert", dto);
	}

	@Override
	public List<ImageDto> getList() {
		// TODO Auto-generated method stub
		return session.selectList("android.getList");
	}

}
