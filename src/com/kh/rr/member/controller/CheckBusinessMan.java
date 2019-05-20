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

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/checkBusiness.me")
public class CheckBusinessMan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckBusinessMan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사업자 로그인체크 서블릿 들어옴");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println("사업자 로그인 체크 : " + loginUser.getUserId());
		ArrayList<HashMap<String, Object>> list = new MemberService().logincheckBusiness(loginUser.getUserId());

		
		System.out.println("서블릿에서 보내주는 list"+list);
		String page = "";
		if(list != null) {
			page = "/views/business/businessFormShop.jsp";
			request.setAttribute("list", list);
			
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사업자 페이지 조회실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
