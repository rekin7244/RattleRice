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

@WebServlet("/loginMember.me")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		
		/*System.out.println(userId);
		System.out.println(password);*/
		Member loginUser = new MemberService().loginCheck(userId, userPwd);
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + userPwd); 
		System.out.println("loginUser : " + loginUser.getMemberType());
		String page ="";

		//System.out.println("userId : "+userId+"\nuserPwd : "+userPwd+"\nloginUser : "+loginUser);
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			if(loginUser.getMemberType().equals("3")) {
				page = "memberlist.ad";
				request.getRequestDispatcher(page).forward(request, response);
			}else if(loginUser.getMemberType().equals("2")){
				System.out.println("멤버 타입 2");
				page = "checkBusiness.me";
				request.getRequestDispatcher(page).forward(request, response);
				
			}else {
				System.out.println(loginUser.getEmail());
				System.out.println(loginUser.getPhone());

				page = "index.jsp";
				response.sendRedirect(page);
			}
		}else{
			response.setContentType("text/html; charset=euc-kr"); // 한글이 인코딩
			PrintWriter out = response.getWriter(); // 선언

			String str = "";
			str = "<script language='javascript'>";
			str += "alert(\"로그인에 실패하였습니다. 아이디 혹은 패스워드를 확인해주세요!\");";
			str += "history.go(-1);";
			str += "</script>";
			out.print(str);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
