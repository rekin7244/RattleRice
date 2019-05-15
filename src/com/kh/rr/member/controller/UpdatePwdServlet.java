package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/updatePwd.me")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePwdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");

		String newUserPwd = request.getParameter("userPwd"); // 변경할 비밀번호 >암호화 DB로
		String CheckUserPwd = request.getParameter("nowUserPwd"); // 현재 비밀번호 > 비암호화
		String nowUserPwd = loginUser.getUserPwd(); // DB에 있는 비밀번호 > 이미 암호화

		if (CheckUserPwd.equals(nowUserPwd)) {

			int result = new MemberService().updatePwd(loginUser, newUserPwd);

			if (result > 0) {
				loginUser.setUserPwd(newUserPwd);
				response.setContentType("text/html; charset=euc-kr"); // 한글이 인코딩
				PrintWriter out = response.getWriter(); // 선언
				
				String str = "";
				str = "<script language='javascript'>";
				str += "alert(\"비밀번호 변경 완료!\");";
				str += "history.go(-1);"; // 창닫기
				str += "</script>";
				out.print(str);
			} else {
				response.setContentType("text/html; charset=euc-kr"); // 한글이 인코딩
				PrintWriter out = response.getWriter(); // 선언

				String str = "";
				str = "<script language='javascript'>";
				str += "alert(\"비밀번호 변경 실패!\");";
				str += "</script>";
				out.print(str);
			}
		} else {
			response.setContentType("text/html; charset=euc-kr"); // 한글이 인코딩
			PrintWriter out = response.getWriter(); // 선언

			String str = "";
			str = "<script language='javascript'>";
			str += "alert(\"비밀번호를 다시 확인하세요\");";
			str += "history.go(-1);"; // 창닫기
			str += "</script>";
			out.print(str);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
