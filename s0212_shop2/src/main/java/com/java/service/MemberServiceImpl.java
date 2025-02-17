package com.java.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage.RecipientType;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	// 이메일전송 객체
	@Autowired JavaMailSender javaMailSender;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

//	@Async // 비동기방식으로 변경
	@Override	// 이메일 발송
	public String sendEmail(String email) {
		String pwCode = getCreateKey();
		// 네이버 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 입력받은 이메일 주소로 송부
		message.setFrom("wonwow55@naver.com");
		message.setSubject("[제목] 가입을 위한 임시비밀번호 보냄.");
		message.setText("안녕하세요. 회원가입을 위한 이메일인증 임시 비밀번호를 보내 드립니다.\n"+
		"[임시비밀번호 : "+pwCode+" ]");
		javaMailSender.send(message); // 10초
		System.out.println("이메일 전송완료!!");
		return pwCode;
	}
	
	@Override	// 이메일 발송
	public String sendEmail2(String email) {
		String pwCode = getCreateKey();
		// 네이버 이메일 발송
		jakarta.mail.internet.MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			message.setSubject("[ 안내 ] 회원가입코드 비밀번호를 보내드립니다.");
			String hdata = "<tr>\r\n"
					+ "	<td style='width:700px;height:196px;padding:0;margin:0;vertical-align:top;'>\r\n"
					+ "		<table width='618' height='194' cellpadding='0' cellspacing='0' align='center' style='margin:0 0 0 40px;border:1px #D9D9D9 solid;'>\r\n"
					+ "		<tr>\r\n"
					+ "			<td style='width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;'>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='../images/email/img_txt_password02.jpg' alt='JARDIN에서 비밀번호 찾기를 요청하셨습니다.' /></p>\r\n"
					+ "				<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 PASSWORD는 회원가입을 위한 임시코드 비밀번호입니다.</p>\r\n"
					+ "				<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>회원가입 코드 패스워드 : <span style='color:#f7703c;line-height:1;'>"+pwCode+"</span></strong></p>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
					+ "			</td>\r\n"
					+ "		</tr>\r\n"
					+ "		</table>\r\n"
					+ "	</td>\r\n"
					+ "<tr>\r\n"
					+ "";
			message.setText(hdata,"utf-8","html");
			// 보내는 이메일주소
			message.setFrom(new InternetAddress("wonwow55@naver.com"));
			// 받는 이메일주소
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			javaMailSender.send(message);
		} catch (MessagingException e) {e.printStackTrace();}
		System.out.println("이메일 전송완료!!");
		return pwCode;
	}
	
	public String getCreateKey() {
		String pwCode = "";
		char[] charSet = {
			'0','1','2','3','4','5','6','7','8','9',
			'A','B','C','D','E','G','F','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T',
			'U','V','W','X','Y','Z'};
		
		// 10자리 비밀번호 생성
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwCode += ""+charSet[idx];
		}
		System.out.println("임시비밀번호 생성 : "+pwCode);
		return pwCode;
	}
	
}
