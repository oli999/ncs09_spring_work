package com.gura.spring05.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	@Autowired 
	private FileService service;
	
	//파일 목록 보기 요청 처리 
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView, 
			HttpServletRequest request) {
		//파일 목록과 페이징 처리에 필요한 값들을 request 에 담아주는 서비스 메소드 호출하기 
		service.list(request);
		
		mView.setViewName("file/list");
		return mView;
	}
	//파일 업로드 폼 요청 처리
	@RequestMapping("/file/upload_form")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		
		return new ModelAndView("file/upload_form");
	}
	
	//파일 업로드 요청 처리
	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request,
			@ModelAttribute FileDto dto) {
		
		service.saveFile(request, dto);
		
		return new ModelAndView("redirect:/file/list.do");
	}
}













