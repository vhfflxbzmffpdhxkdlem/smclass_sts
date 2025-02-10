package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {
	
	// 게시글 전체보기
	ArrayList<BoardDto> blist();
	
	// 글쓰기 저장
	void bwrite(BoardDto bdto);
	// 1개 개시글 가져어기
	BoardDto bview(int bno);
	// 게시글 삭제
	void bdelete(int bno);

}
