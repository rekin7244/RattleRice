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
import com.kh.rr.admin.model.service.StatisticsService;

/**
 * Servlet implementation class StatisticsSalesServlet
 */
@WebServlet("/statisticsSales.st")
public class StatisticsSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsSalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HashMap<String,Object>> saleslist = new StatisticsService().statisticsSales();
		ArrayList<HashMap<String,Object>> selltelist = new StatisticsService().statisticsSettle();
		ArrayList<HashMap<String,Object>> refundlist = new StatisticsService().statisticsRefund();
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		hmap.put("list", saleslist);
		hmap.put("list2", selltelist);
		hmap.put("list3", refundlist);
		if(hmap != null) {
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
