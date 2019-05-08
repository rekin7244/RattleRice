package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.UserInfo;

@WebServlet("/userInfo.me")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member reqMember = (Member)request.getSession().getAttribute("loginUser");
		
		UserInfo reqUi = new UserInfoService().userInfo(reqMember.getUserId());
		
		
		String page = "";
		if(reqUi != null) {
			page = "views/matching/myPage.jsp";
			request.setAttribute("reqUi", reqUi);
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "개인정보 조회 실패!");
			request.getRequestDispatcher(page).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
