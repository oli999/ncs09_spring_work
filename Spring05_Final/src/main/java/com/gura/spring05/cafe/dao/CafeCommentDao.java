package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeCommentDto;

public interface CafeCommentDao {
	public List<CafeCommentDto> getList(int ref_group);
	public void delete(int num);
	public void insert(CafeCommentDto dto);
	public int getSequence();
	public void update(CafeCommentDto dto);
}










