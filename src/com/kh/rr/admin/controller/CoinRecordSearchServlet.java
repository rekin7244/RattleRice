package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.common.model.vo.PageInfo;

/**
 * Servlet implementation class CoinRecordSearchServlet
 */
@WebServlet("/searchCoinRecord.ad")
public class CoinRecordSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoinRecordSearchServlet() {
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
		String condition = request.getParameter("condition");
		String userId = request.getParameter("userId");
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		int listCount = new AdminService().searchCoinRecordListCount(condition,userId);
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (currentPage - 1) * limit + 1;
		endPage = startPage + limit - 1;
		
		PageInfo pi = new PageInfo(currentPage,limit,maxPage,startPage,endPage);
		
		ArrayList<HashMap<String,Object>> list = new AdminService().searchCoinRecord(pi,condition,userId);
		
		HashMap<String, Object> hmap = new HashMap<String,Object>();
		hmap.put("pi", pi);
		hmap.put("list",list);
		
		if(list != null) {
			response.setContentType("application/json");
			new Gson().toJson(hmap, response.getWriter());
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
