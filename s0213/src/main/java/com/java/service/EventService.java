package com.java.service;

import java.util.ArrayList;

import com.java.dto.EventDto;

public interface EventService {
	
	// 이벤트 전체 게시판
	ArrayList<EventDto> elist();
	// 이벤트 상세페이지
	EventDto eventdto(int eno);

}
