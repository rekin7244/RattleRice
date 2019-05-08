package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;


@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertMemberServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String memberType = request.getParameter("memberType");
		
		
		/*if(irr != null) {
			for (int i = 0; i < irr.length; i++) {
				if(i == 0) {
					interest += irr[i];
				}else {
					interest += ", " + irr[i];
				}
			}
		}*/
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + userPwd);
		
		
		//service 호출
		Member reqMember = new Member();
		reqMember.setUserId(userId);
		reqMember.setUserPwd(userPwd);
		reqMember.setUserName(userName);
		reqMember.setMemberType(memberType);
		
		int result = new MemberService().insertMember(reqMember);
		
		String page = "";
		if(result > 0) {
			page = "index.jsp";
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";	
			request.setAttribute("msg", "회원 가입 실패!");
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
