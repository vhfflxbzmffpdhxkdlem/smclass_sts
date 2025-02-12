package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;


@Mapper
public interface CustomerMapper {
	// 전체 게시글
	java.util.ArrayList<com.java.dto.BoardDto> selectAll();
	// 게시글 상세보기
	BoardDto selectOne(int bno);
	// 이전게시글 정보, 다음게시글 정보
	BoardDto selectOnePrev(int bno);
	BoardDto selectOneNext(int bno);
	// 조회수 1 증가 - update
	void updateBhit(int bno);
	

	
}
