package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/selectPoint")
public class SelectPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectPointServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		ArrayList<HashMap<String, Object>> list = new UserInfoService().selectUserPoint(userId);
		
		String page ="";
		if(list != null) {
			page = "views/member/myPointForm.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "포인트 조회 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
