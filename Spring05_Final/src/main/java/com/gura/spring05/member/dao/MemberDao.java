package com.gura.spring05.member.dao;

import java.util.List;
import java.util.Map;

import com.gura.spring05.member.dto.MemberDto;

public interface MemberDao {
	public List<MemberDto> getList();
	public void delete(int num);
	public void insert(MemberDto dto);
	public MemberDto getData(int num);
	public void update(MemberDto dto);
	//안드로이드 테스트용 메소드
	public List<Map<String, Object>> getList2();
	public List<Map<String, Object>> memberGetList();
}






