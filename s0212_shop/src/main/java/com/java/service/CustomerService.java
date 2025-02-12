package com.java.service;

import java.util.Map;

import com.java.dto.BoardDto;

public interface CustomerService {

	// 전체리스트
	java.util.ArrayList<com.java.dto.BoardDto> notice();
	
	// 게시글 상세보기
	Map<String, Object> nview(int bno);


}
