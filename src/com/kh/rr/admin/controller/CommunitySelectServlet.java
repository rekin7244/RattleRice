package com.kh.rr.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.board.model.vo.Board;


@WebServlet("/communitySelect.ad")
public class CommunitySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommunitySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nbid = Integer.parseInt(request.getParameter("nbid"));
		
		System.out.println(nbid);

		Board community = new AdminService().selectCommunity(nbid);
		
		
		
		String page = "";
		if(community != null) {
			page="views/admin/communityUpdate.jsp";
			request.setAttribute("community", community);
			
		}else {
			System.out.println("실패!!");
		}
	
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
