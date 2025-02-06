package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.StuDto;

public class BseviceImpl implements Bservice {

	public String slist() {
		ArrayList<StuDto> list = new ArrayList();
		return "stu여러새보냄";
	}
	
}
