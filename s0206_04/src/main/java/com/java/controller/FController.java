package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;



@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	@GetMapping("/member")
	public String member() {
		
		return "member";
	}
	@PostMapping("/meminfo")
	public String meminfo(MemDto mdto,Model model) {
		model.addAttribute("member",mdto);
		return "meminfo";
	}
	
	
	@GetMapping("/stuinput")
	public String stuinput() {
		
		return "stuinput";
	}
	@PostMapping("/stuinfo")
	public String stuinfo(StuDto sdto,Model model) {
		int total = sdto.getKor()+sdto.getEng()+sdto.getMath();
		sdto.setTotal(total);
		sdto.setAvg(total/3.0);
		model.addAttribute("stu",sdto);
		return "stuinfo";
	}
	
}
