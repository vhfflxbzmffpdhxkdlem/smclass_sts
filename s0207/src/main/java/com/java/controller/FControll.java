package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FControll {

 @GetMapping("/")
 public String index(String chk) {
	 System.out.println("chk값 : "+chk);
     return "index";
 }
 
	
	
}
