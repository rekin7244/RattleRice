package com.kh.w6.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.w6.member.model.service.MemberService;
import com.kh.w6.member.model.vo.Member;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int JOIN_OK = 1;
	public static int JOIN_X = 0;

	public JoinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.한글에대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 2. 전송값 꺼내서 변수에 기록하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String[] hobbies = request.getParameterValues("hobby");

		String hobby = String.join(",", hobbies);

		// 3. 비지니스 로직
		Member requestMember = new Member();
		requestMember.setUserId(userId);
		requestMember.setUserPwd(userPwd);
		requestMember.setUserName(userName);
		requestMember.setAge(age);
		requestMember.setGender(gender);
		requestMember.setEmail(email);
		requestMember.setPhone(phone);
		requestMember.setAddress(address);
		requestMember.setHobby(hobby);

		int joinUser = new MemberService().joinMember(requestMember);

		// 4. 받은 결과에 따라 성공, 실패 페이지 보내기

		String view = "";

		if (joinUser == JOIN_OK) {

			view = "views/member/loginForm.jsp";

			response.sendRedirect(view);

		}/* else {
			String msg;
			msg = "같은 아이디가 존재합니다.";
			request.setAttribute("msg", msg);
			view = "views/common/errorPage.jsp";
		}*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
