package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

/**
 * Servlet implementation class BusinessSalesFromServlet
 */
@WebServlet("/businessSales.s")
public class BusinessSalesFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessSalesFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사업자 통계 서블릿");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		ArrayList<HashMap<String, Object>> list = new MemberService().logincheckBusiness(loginUser.getUserId());
		
		System.out.println("리턴값 가지고 사업자 통계 서블릿 되돌아옴");
		String page = "";
		if(list != null) {
			page="/views/business/businessFormSales.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사업자 페이지 조회실패");
		}
			request.getRequestDispatcher(page).forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
