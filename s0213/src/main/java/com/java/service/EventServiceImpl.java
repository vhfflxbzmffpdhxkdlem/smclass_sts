package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventMapper eventMapper;
	
	@Override // 이벤트 전체 게시판
	public ArrayList<EventDto> elist() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}

	@Override // 이벤트 상세 페이지
	public EventDto eventdto(int eno) {
		EventDto eventdto = eventMapper.selectOne(eno);
		return eventdto;
	}

}
