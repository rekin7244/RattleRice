package com.kh.rr.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;

/**
 * Servlet implementation class FAQinsertServlet
 */
@WebServlet("/FAQinsert.ad")
public class FAQinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQinsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		
		System.out.println("카테고리 : " + category);
		System.out.println("글 제목 : " +title);
	
		
		Board FAQ = new Board();
		
		FAQ.setTitle(title);
		FAQ.setbContent(content);
		FAQ.setfCategory(category);
		
		System.out.println(FAQ);
		
		int result = new AdminService().insertFAQ(FAQ);
		 
		
		String page = "";
		if(result > 0) {
			response.sendRedirect("/rr/FAQlist.ad");
		}else {
			System.out.println("실패");
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
