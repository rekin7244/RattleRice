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
import com.kh.rr.member.model.vo.Member;

@WebServlet("/selectPro")
public class SelectProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		ArrayList<HashMap<String, Object>> list = new AttachmentService().selectAttachmentlList(userId);
		String page ="";
		if(list != null) {
			if(loginUser.getMemberType().equals("2")) {
				page = "views/business/businessFormUpdate";
				request.setAttribute("list", list);
			}
			page = "views/member/myPageForm.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "프로필 조회 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
