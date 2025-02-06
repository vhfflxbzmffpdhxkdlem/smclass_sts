package com.java.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;
import com.java.dto.StuDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam String id,           // form name="id" 데이터 입력받음
			@RequestParam(required=false) String pw, // null값 허용
//			String name,     // @RequestParam 생략가능, form 이름과 같아야 함.
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng, // 값이 없으면 0으로 세팅
			int math,
			Model model) {
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//
//		kor = Integer.parseInt(akor);
//		eng = Integer.parseInt(aeng);
//		math = Integer.parseInt(amath);
		int total = kor+eng+math;
		double avg = Math.round((total / 3.0) * 100.0) / 100.0;
		
		System.out.println("데이터 : "+id+","+pw);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
//		model.addAttribute("member",MemberDto.builder().id(id).pw(pw).build());
//		@PostMapping("/login");
		return "login";
	}
		
		@GetMapping("/stuinput")
		public String stuinput() {
			return "stuinput";
		}
		
//		public String stuinfo(HttpServletRequest request,
//				String stuNo,String name,int kor,int eng,int math,Model model) {
//
//			int total = kor+eng+math;
//			double avg = Math.round((total / 3.0) * 100.0) / 100.0;
//			
//			StuDto s = StuDto.builder().stuNo(stuNo).name(name).
//					kor(kor).eng(eng).math(math).total(total).avg(avg).build();
//			model.addAttribute("stu",s);
//			model.addAttribute("stuNo",stuNo);
//			model.addAttribute("name",name);
//			model.addAttribute("kor",kor);
//			model.addAttribute("eng",eng);
//			model.addAttribute("math",math);
//			model.addAttribute("total",total);
//			model.addAttribute("avg",avg);
//		
//		return "stuinfo";
//	}
	@GetMapping("/doard")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno : "+bno);
		System.out.println("btitle : "+btitle);
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		return "board";
	}
		
}
