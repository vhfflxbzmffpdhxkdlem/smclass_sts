package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;

	// 회원전체 가져오기
	@GetMapping("/member/mlist")
	public String mlist() {
		List<MemberDto> list = memberService.FindAll();
		return "member/mlist";
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response) {
//		// 쿠키 생성 - 자바에서 생성
//		Cookie cookie = new Cookie("cook_id","aaa");
//		cookie.setMaxAge(60*624); // 1일
//		response.addCookie(cookie); // cookie 저장
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
