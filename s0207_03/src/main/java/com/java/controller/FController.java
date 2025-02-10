package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.dto.MemberDto;
import com.java.service.BService;
import com.java.service.MService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;


@Controller
public class FController {

	@Autowired BService bService;
	
	@Autowired MService mService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/mlist")
	public String mlist(Model model) {
		System.out.println("컨트롤러 정상");
		ArrayList<MemberDto> list = mService.mlist();
		model.addAttribute("list",list);
		return "mlist";
	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		return "/blist";
	}
}
