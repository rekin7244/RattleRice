package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/login.kk")
public class KakaoLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KakaoLoginCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("data");
		
		System.out.println(id);
		
		Member reqMember = new MemberService().kakaoCheck(id);
		
		if(reqMember != null) {
			System.out.println("이미 있는 회원!");
		}else {
			System.out.println("신규 회원!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
