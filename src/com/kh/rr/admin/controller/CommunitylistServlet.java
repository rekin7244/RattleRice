package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;


@WebServlet("/communitylist.ad")
public class CommunitylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommunitylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Board> list = new AdminService().communitylist();
		
		System.out.println("서블릿실행 : " + list);
		
		String page="";
		
		if(list != null) {
			page="views/admin/community.jsp";
			request.setAttribute("list", list);
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
