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
 * Servlet implementation class FAQselectServlet
 */
@WebServlet("/FAQselect.ad")
public class FAQselectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQselectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fbid = Integer.parseInt(request.getParameter("fbid"));
		
		
		Board FAQ = new AdminService().selectFAQ(fbid);
		
		
		
		String page = "";
		if(FAQ != null) {
			page="views/admin/FAQUpdate.jsp";
			request.setAttribute("FAQ", FAQ);
			
		}else {
			System.out.println("실패!!");
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
