package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired MemberService memberService;
//	MemberService memberService2 = new MemberServiceImpl();
	@Autowired HttpSession session;
	
	@GetMapping("/") //메인페이지
	public String index() {
		return "index";
	}
	
}// class








