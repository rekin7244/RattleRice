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
		
		
		String title = request.getParameter("title");
		int nbid = Integer.parseInt(request.getParameter("nbid"));
		String content = request.getParameter("content");
		
		System.out.println("제목 : " + title);
		System.out.println(nbid);
		System.out.println("내용 : " + content);
		
		
		Board community = new Board();
		community.setTitle(title);
		community.setNbid(nbid);
		community.setbContent(content);
		
		System.out.println("공지사항수정서블릿");
		
		int result = new AdminService().updateNotice(community);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectOne.ad?num=" + community.getNbid());
		}else {
			System.out.println("공지사항수정실패");
	
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
