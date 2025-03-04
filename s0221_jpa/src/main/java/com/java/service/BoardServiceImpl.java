package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	
	@Override // 전체 게시판
	public Page<BoardDto> findAll(Pageable pageable) {
		// Sort 다중정렬을 사용해서 검색
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),Sort.Order.asc("bstep")
//				);
//		List<BoardDto> list = boardRepository.findAll(sort);

		// navtiveQuery
		Page<BoardDto> list = boardRepository.findAll(pageable);
		return list;
	}

	@Override // 상세게시판
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				()->{ // 람다식 
					return new IllegalArgumentException("데이터 처리시 에러!!");
				});
		boardDto.setBhit(boardDto.getBhit()+1); //게시글 조회수 1 증가
//		boardRepository.save(boardDto);
		return boardDto;
	}

	@Override // 게시글 검색
	public List<BoardDto> findByBtitleContaining(String search) {
		List<BoardDto> list = boardRepository.findByBtitleContaining(search);
		return list;
	}

}
