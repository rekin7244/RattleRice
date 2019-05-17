package com.kh.rr.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;


@WebServlet("/communityInsert.ad")
public class CommunityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommunityInsertServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String target = request.getParameter("target");
		
		System.out.println(title);
		
		System.out.println(content);
		System.out.println(target);
		
		Board community = new Board();
		
		community.setTitle(title);
		community.setbContent(content);
		community.setTarget(target);
		
		int result = new AdminService().insertCommunity(community);
		 
		
		String page = "";
		if(result > 0) {
			response.sendRedirect("/rr/communitylist.ad");
		}else {
			System.out.println("실패");
		}
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
