package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/loginKakao.me")
public class KakaoLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KakaoLoginCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPwd = request.getParameter("userPwd");
		String userId = request.getParameter("userId");
		//userId 값으로 기존회원 인지 판별함
		Member reqMember = new MemberService().kakaoCheck(userId);
		
		//기존 회원일 경우 바로 로그인 처리
		if(reqMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", reqMember);
			
			response.getWriter().print("기존회원");
		//기존 회원 아닐 경우, 추가 정보 입력받아서 회원가입 처리
		}else {
			Member newMember = new Member();
			newMember.setUserPwd(userPwd);
			response.getWriter().print(userPwd);
			response.getWriter().print(","+userId);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
