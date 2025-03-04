package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer>{
	// Memberdto 로그인부분 쿼리
//	@Query(value = "select * from memberdto where id=? and pw=?",
//			nativeQuery = true)
//	Optional<memberDto> findByIdAndPw(String id,String pw);
	
//	@Query(value = "select * from boarddto order by bgroup desc, bstep asc",
//			nativeQuery = true)
	List<BoardDto> findAll();
	
	// 게시판 검색
	// select * from boarddto where btitle like '%search%'
//	@Query(value = "select * from boarddto where btitle like %:search%",
//			nativeQuery = true)
//	List<BoardDto> findByBtitleOrContaining(String search);
	List<BoardDto> findByBtitleContaining(String search);
}
