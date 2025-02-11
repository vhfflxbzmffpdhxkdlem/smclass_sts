package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class MController {

	@Autowired MemberService memberSerivce;
	
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	@PostMapping("/member/login")
	public String login(MemberDto mdto) {
		MemberDto memberDto = memberSerivce.login(mdto);
		return "redirect:/";
	}
}
