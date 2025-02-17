package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@ResponseBody //이메일 발송
	@PostMapping("/member/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : "+email);
//		String pwcode = memberService.sendEmail(email); // email발송 - text
		String pwcode = memberService.sendEmail2(email); // email발송 - html
				
		return pwcode;
	}
	
	@GetMapping("/member/step01") // 회원가입
	public String step01() {
		return "member/step01";
	}
	
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("controller id : "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk",0);
			return "member/login";
		}
	}

}
