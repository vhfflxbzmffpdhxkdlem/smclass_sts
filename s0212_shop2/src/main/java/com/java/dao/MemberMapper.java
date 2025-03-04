package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;
import com.java.service.List;

@Mapper
public interface MemberMapper {

	MemberDto selectLogin(MemberDto mdto);

	// 리엑트 회원전체 가져오기
	List<MemberDto> selectAll();
	// 리엑트 회원1aud 가져오기
	MemberDto selectOne(String id);

}
