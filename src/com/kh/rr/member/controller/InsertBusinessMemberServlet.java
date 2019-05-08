package com.kh.rr.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/insertBMember.me")
public class InsertBusinessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public InsertBusinessMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = "사업자이름";
		String memberType = request.getParameter("memberType");
		
		//service 호출
		Member reqMember = new Member();
		reqMember.setUserId(userId);
		reqMember.setUserPwd(userPwd);
		reqMember.setUserName(userName);
		reqMember.setMemberType(memberType);
		
		int result = new MemberService().insertBusinessMember(reqMember);
		
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
