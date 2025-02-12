package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;

	@Override // 게시글 전체보기
	public ArrayList<BoardDto> notice() {
		ArrayList<BoardDto> list = customerMapper.selectAll();
		return list;
	}

	@Override // 게시글 상세보기
	public Map<String, Object> nview(int bno) {
		Map<String, Object> map = new HashMap<>();
		customerMapper.updateBhit(bno);
		BoardDto boardDto = customerMapper.selectOne(bno);
		BoardDto prevDto = customerMapper.selectOnePrev(bno);
		BoardDto nextDto = customerMapper.selectOneNext(bno);
		map.put("boardDto",boardDto);
		map.put("prevDto",prevDto);
		map.put("nextDto",nextDto);
		return map;
	}
	


}
