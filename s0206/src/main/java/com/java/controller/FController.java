package com.java.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index페이지가 열립니다.");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("ligin get방식");
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("ligin post방식");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		session.setAttribute("session_id", id);
		
		return "logininfo";
	}
	
	@RequestMapping("/logout") // getMapping,postMapping 2개 모두 사용
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby=""; // "게임,골프,수영"
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += "," +hobbys[i];
		}
		
		// model사용
//		model.addAttribute("member",new MemberDto(id,pw,name,tel,gender,hobby));

		// ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meminfo");
		mv.addObject("member",new MemberDto(id,pw,name,tel,gender,hobby));
		
		return mv;
	}
	
	@GetMapping("/meminfo")
	public String meminfo() {
		return "meminfo";
	}
	
}
