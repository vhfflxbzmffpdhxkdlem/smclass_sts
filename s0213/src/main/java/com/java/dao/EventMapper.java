package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.EventDto;

@Mapper
public interface EventMapper {
	
	// 이벤트 전체리스트
	ArrayList<EventDto> selectAll();
	// 이벤트 상세 페이지
	EventDto selectOne(int eno);

}
