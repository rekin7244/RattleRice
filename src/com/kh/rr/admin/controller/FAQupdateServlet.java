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
 * Servlet implementation class FAQupdateServlet
 */
@WebServlet("/FAQupdate.ad")
public class FAQupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int fbid = Integer.parseInt(request.getParameter("fbid"));
		String content = request.getParameter("content");
		
		System.out.println("제목 : " + title);
		System.out.println(fbid);
		System.out.println("내용 : " + content);
		
		
		Board FAQ = new Board();
		FAQ.setTitle(title);
		FAQ.setFbid(fbid);
		FAQ.setbContent(content);
		
		System.out.println("공지사항수정서블릿");
		
		int result = new AdminService().updateFAQ(FAQ);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/FAQselectOne.ad?num=" + FAQ.getFbid());
		}else {
			System.out.println("공지사항수정실패");
	
		}
		
		
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
