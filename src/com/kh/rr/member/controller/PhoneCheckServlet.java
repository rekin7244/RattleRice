package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.rr.admin.model.vo.Coolsms;



@WebServlet("/telCheck")
public class PhoneCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PhoneCheckServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String api_key = "NCSBWER7HGSJGFAEE";
		String api_secret = "VE4YYCDBKVITIJMO0TY6NIWZ09A6GOVS";
		Coolsms coolsms = new Coolsms(api_key, api_secret);
		
		String rand = request.getParameter("rand");
		String phoneNumber = request.getParameter("phoneNumber");
		
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", phoneNumber); // 수신번호    
		set.put("from", "01051540825"); // 발신번호 
		set.put("text", "딸랑밥에서 보낸 인증 문자 입니다! ["+rand+"] 정확하게 입력해 주세요!"); // 문자내용
		set.put("type", "sms"); // 문자 타입
		
		System.out.println("서릿이 받은 폰번호 : " +phoneNumber);
		
		System.out.println("서릿이 받은 랜덤값 : " +rand);
		
		coolsms.send(set); // 보내기&전송결과받기
		
	}    
	
	
	
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
