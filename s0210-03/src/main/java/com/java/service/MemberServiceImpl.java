//package com.java.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.java.dao.MemberMapper;
//import com.java.dto.MemberDto;
//
//@Service
//public class MemberServiceImpl implements MemberService {
//
//	@Autowired MemberMapper memberMapper;
//	
//	@Override // 로그인 확인
//	public ArrayList<MemberDto> login(MemberDto mdto) {
//		ArrayList<MemberDto> list = memberMapper.seletLogin();
//		return list;
//	}
//
//}
