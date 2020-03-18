package com.gura.spring05.android;

import java.util.List;

public interface AndroidDao {
	public void insert(ImageDto dto);
	public List<ImageDto> getList();
}
