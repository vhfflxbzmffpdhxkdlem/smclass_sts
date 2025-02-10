package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

public class MserviceImpl implements MService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberDto> mlist() {
		ArrayList<MemberDto> list = new ArrayList<>();
		list = memberMapper.mlist();
		return null;
	}

}
