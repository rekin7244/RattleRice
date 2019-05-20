package com.kh.rr.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;


@WebServlet("/selectOne.ad")
public class SelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		Board community = new AdminService().selectOne(num);
		
		System.out.println("게시판 상세보기 서블릿");
		
		String page="";
		if(community != null) {
			page="views/admin/communityDetail.jsp";
			request.setAttribute("community", community);
		}else {
			System.out.println("상세보기 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
