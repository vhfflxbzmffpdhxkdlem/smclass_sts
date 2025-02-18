package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@ResponseBody //이메일 발송
	@PostMapping("/member/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : "+email);
		String pwcode = memberService.sendEmail(email); // email발송 - text
//		String pwcode = memberService.sendEmail2(email); // email발송 - html
				
		return pwcode;
	}
	
	@ResponseBody //이메일 발송
	@PostMapping("/member/sendEmail2")
	public String sendEmail2(String email) {
		System.out.println("sendEmail : "+email);
		String pwcode = memberService.sendEmail2(email); // email발송 - html
		session.setAttribute("pwcode", pwcode);
		return pwcode;
	}
	
	@ResponseBody //인증코드 확인
	@PostMapping("/member/pwcodeCheck")
	public String pwcodeCheck(String pwcode) {
		System.out.println("pwcodeCheck : "+pwcode);
		String pw = (String)session.getAttribute("pwcode");
		if(pwcode.equals(pw)) {
			return "1";
		}else {
			return "0";
		}
	}
	
	@GetMapping("/member/step02") // 회원가입2
	public String step02() {
		session.removeAttribute("pwcode"); // 섹션삭제
		return "member/step02";
	}
	
	
	@GetMapping("/member/step01") // 회원가입
	public String step01() {
		return "member/step01";
	}
	
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response) {
		// 쿠키 생성 - 자바에서 생성
		Cookie cookie = new Cookie("cook_id","aaa");
		cookie.setMaxAge(60*624); // 1일
		response.addCookie(cookie); // cookie 저장
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
