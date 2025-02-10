package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	
	@Override // 게시글 전체리스트
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardmapper.selectAll();
		return list;
	}

	@Override // 게시글 저장
	public void boardWrite(BoardDto bdto) {
		boardmapper.insertBoard(bdto);
	}

}
