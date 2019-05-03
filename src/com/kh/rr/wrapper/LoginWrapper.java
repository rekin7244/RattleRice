package com.kh.rr.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper{
	//httpservletrequest를 가공해서 사용하기 위한 클래스
	//동적 바인딩 적용해서 여기에 적은 메소드 내용이 먼저 동작하게 하기 위함
	public LoginWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value="";
				
		if(key != null && key.equals("userPwd")) {
			//패스워드인 경우 암호화를 해줌
			value = getSha512(super.getParameter("userPwd"));
			
		}else {
			value = super.getParameter(key);
		}
		
		return value;
	}

	private static String getSha512(String pwd) {
		String encPwd = null;
		//암호화 한 후에 리턴해줌
		
		//해쉬 함수 
		//어떤 문자를 넣던 동일한 길이의 문자열을 리턴해줌
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("utf-8"));
			
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPwd;
	}

}
