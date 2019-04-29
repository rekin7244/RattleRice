package com.kh.w6.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.w6.member.model.service.MemberService;
import com.kh.w6.member.model.vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 처리를 위한 상수 선언
	public static int LOGIN_OK = 1;
	public static int WRONG_PASSWORD = 0;
	public static int ID_NOT_EXIST = -1;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 2. 값 꺼내기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("password");

		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + userPwd);

		// 3. 비지니스 로직 처리할 서비스 클래스의 메소드로 전달값 넘김
		Member requestMember = new Member();
		requestMember.setUserId(userId);
		requestMember.setUserPwd(userPwd);

		Member loginUser = new MemberService().loginMember(requestMember);

		// 4. 받은 결과에 따라서 성공. 실패 페이지 내보내기
		String view = "";

		if (loginUser.getStatus() == LOGIN_OK) {

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			// request.setAttribute("loginUser", loginUser);

			view = "views/main/main.jsp";

			response.sendRedirect(view);

		} else {
			String msg;
			if (loginUser.getStatus() == WRONG_PASSWORD) {
				msg = "패스워드를 잘못 입력하셨습니다.";
			} else {
				msg = "존재하지 않는 아이디 입니다.";
			}
			request.setAttribute("msg", msg);
			view = "views/common/errorPage.jsp";
		}

		// RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		// reqDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
