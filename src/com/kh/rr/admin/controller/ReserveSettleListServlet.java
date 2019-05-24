package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.common.model.service.ReservationService;
import com.kh.rr.common.model.vo.PageInfo;
import com.kh.rr.common.model.vo.Reservation;

/**
 * Servlet implementation class ReserveSettleListServlet
 */
@WebServlet("/reserveSettleList.ad")
public class ReserveSettleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveSettleListServlet() {
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
		limit = 9;
		int listCount = new ReservationService().reserveSettleListCount();
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (currentPage - 1) * limit + 1;
		endPage = startPage + limit - 1;
		
		PageInfo pi = new PageInfo(currentPage,limit,maxPage,startPage,endPage);
		
		ArrayList<HashMap<String,Object>> list = new ReservationService().reserveSettleList(pi);
		
		
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
