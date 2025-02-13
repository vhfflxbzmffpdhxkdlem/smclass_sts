package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.EventDto;
import com.java.service.EventService;

@Controller
public class EventController {

	@Autowired EventService eventService;
	
	@GetMapping("/event/eview")
	public String eview(int eno, Model model) {
		EventDto eventDto = eventService.eventdto(eno);
		model.addAttribute("edto",eventDto);
		return "/event/eview";
	}
	
	@GetMapping("/event/event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.elist();
		model.addAttribute("list",list);
		return "/event/event";
	}
}
