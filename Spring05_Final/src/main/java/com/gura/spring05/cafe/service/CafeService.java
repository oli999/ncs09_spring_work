package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	public void saveContent(CafeDto dto);
	public void getDetail(HttpServletRequest request);
	public void deleteContent(int num, HttpServletRequest request);
}
