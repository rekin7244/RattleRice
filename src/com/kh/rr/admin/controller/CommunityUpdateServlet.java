package com.kh.rr.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;


@WebServlet("/communityUpdate.ad")
public class CommunityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommunityUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nbid=Integer.parseInt(request.getParameter("nbid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("수정서블릿");
		System.out.println(title);
		System.out.println(content);
		
		Board community = new Board();
		
		community.setTitle(title);
		community.setbContent(content);
		community.setNbid(nbid);
		
		System.out.println(community);
		
		int result = new AdminService().updateCommunity(community);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath() + "/selectOne.ad?nbid=" + community.getNbid());
		}else {
			System.out.println("수정실패");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
