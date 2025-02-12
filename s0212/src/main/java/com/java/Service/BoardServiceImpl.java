package com.java.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;

	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override // 게시글 저장
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
		
	}

	@Override 	// 게시글 1개 가져오기
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}
	
	
}
