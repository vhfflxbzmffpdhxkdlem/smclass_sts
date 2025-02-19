package com.java.servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoerdServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
	}

	@Override // 상세보기
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

}
