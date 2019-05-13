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

import com.kh.rr.member.model.service.MemberService;

/**
 * Servlet implementation class CheckBusinessMan
 */
@WebServlet("/checkBusiness.me")
public class CheckBusinessMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBusinessMan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사업자 로그인체크 서블릿 들어옴");
		String userId = request.getParameter("userId");
		ArrayList<HashMap<String, Object>> list = new MemberService().logincheckBusiness(userId);
		
		System.out.println("리턴값 가지고 사업자 서블릿 되돌아옴");
		String page = "";
		if(list != null) {
			System.out.println("list : " + list);
			//page = "/views/business/businessFormUpdate.jsp";
			//page = request.getContextPath()+"/views/business/reservationForm.jsp";
			//request.setAttribute("list", list);
			//response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사업자 페이지 조회실패");
		}
		//request.getRequestDispatcher(page).forward(request, response);
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
