package com.gura.spring05.file.dao;

import java.util.List;

import com.gura.spring05.file.dto.FileDto;

public interface FileDao {
	public int getCount(FileDto dto);
	public List<FileDto> getList(FileDto dto);
	public void insert(FileDto dto);
	public FileDto getData(int num);
	public void addDownCount(int num);
	public void delete(int num);
}






