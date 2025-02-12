package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.Service.BoardService;
import com.java.dto.BoardDto;

@RestController
public class RController {

//	# @RestController #
//	데이터를 달라고 하는 것임.
//	spring.mvc.view.suffix=.jsp
	
	@Autowired BoardService boardService;
	
	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
		ArrayList<BoardDto> list = boardService.blist();
		// react에서 -> /restpage호출
		return list;
	}
}
