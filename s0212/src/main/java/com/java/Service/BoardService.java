package com.java.Service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	ArrayList<BoardDto> blist();
	// 게시글 저장
	void bwrite(BoardDto bdto);
	// 게시글 1개 가져오기
	BoardDto bview(int bno);

}
