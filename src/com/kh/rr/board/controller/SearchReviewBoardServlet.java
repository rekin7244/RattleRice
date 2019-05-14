package com.kh.rr.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.board.model.service.BoardService;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;

/**
 * Servlet implementation class SearchReviewBoardServlet
 */
@WebServlet("/searchReviewBoard.bo")
public class SearchReviewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReviewBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = "";
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
		}
		System.out.println("keyword : "+keyword);
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		limit = 5;
		int listCount = new BoardService().getSearchReviewListCount(keyword);
		System.out.println("listCount : "+listCount);
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = (currentPage - 1) * limit + 1;
		endPage = startPage + limit - 1;
		
		PageInfo pi = new PageInfo(currentPage,limit,maxPage,startPage,endPage);
		System.out.println(pi);
		ArrayList<Board> list = new BoardService().searchReviewList(pi, keyword);
		System.out.println(list);
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("list", list);
		hmap.put("pi", pi);
		if(list != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
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
