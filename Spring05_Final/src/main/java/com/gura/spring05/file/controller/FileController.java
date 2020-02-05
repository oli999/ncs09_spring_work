package com.gura.spring05.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	@Autowired 
	private FileService service;
	
}






