package com.gura.spring05.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;

public interface FileService {
	public void list(HttpServletRequest request);
	public void saveFile(HttpServletRequest request, FileDto dto);
	public void getFileData(ModelAndView mView, int num);
	public void addDownCount(int num);
	public void removeFile(HttpServletRequest request);
}






