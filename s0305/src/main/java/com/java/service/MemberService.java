package com.java.service;
//import com.java.controller.List;
import com.java.dto.MemberDto;

public interface MemberService {

	// 회원전체 가져오기
	List<MemberDto> FindAll();

}
