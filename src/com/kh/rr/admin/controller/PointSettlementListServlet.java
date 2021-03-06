package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.admin.model.vo.Settlement;
import com.kh.rr.common.model.vo.PageInfo;

/**
 * Servlet implementation class PointSettlementListServlet
 */
@WebServlet("/pSettlementList.ad")
public class PointSettlementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointSettlementListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		limit = 7;
		int listCount = new AdminService().getPointSettlementListCount();
		maxPage = (int)((double)listCount/limit + 0.9);
		startPage = (currentPage - 1) * limit + 1;
		endPage = startPage + limit - 1;
		
		PageInfo pi = new PageInfo(currentPage,limit,maxPage,startPage,endPage);
		ArrayList<Settlement> list = new AdminService().getPointSettlementList(pi);
		//System.out.println(list);
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/admin/p_calculate.jsp").forward(request, response);;
		} else {
			request.setAttribute("msg", "리스트 조회 실패!");
			request.getRequestDispatcher("views/common/error-500.jsp").forward(request, response);;
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
