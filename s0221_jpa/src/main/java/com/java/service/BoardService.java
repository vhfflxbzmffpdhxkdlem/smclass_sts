package com.java.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.dto.BoardDto;

public interface BoardService {
	// 전체 게시판
	Page<BoardDto> findAll(Pageable pageable);
	// 상세 게시판
	BoardDto findById(int bno);
	// 게시글 검색
	List<BoardDto> findByBtitleContaining(String search);

}
