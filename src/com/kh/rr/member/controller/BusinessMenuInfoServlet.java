package com.kh.rr.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.BusinessMenuInfo;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreMenuInfo;

/**
 * Servlet implementation class BusinessMenuInfoServlet
 */
@WebServlet("/menuInfoUpdate.b")
public class BusinessMenuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BusinessMenuInfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	       Member loginUser = (Member)session.getAttribute("loginUser");
	       
	       String menu = request.getParameter("menu");
	       //int price = Integer.parseInt(request.getParameter("price"));
	       String price = request.getParameter("price");
	       String origin = request.getParameter("origin");
	       
	       StoreMenuInfo menuInfo = new StoreMenuInfo();
	       menuInfo.setMenu(menu);
	       menuInfo.setPrice(price);
	       menuInfo.setOrigin(origin);
	       System.out.println("메뉴인포 서블릿");
	       System.out.println("menuInfo : " + menuInfo);
			
			
			if(menuInfo != null) {
				int result1 = new BusinessMenuInfo().menuUpdate(menuInfo, loginUser);
			}else {
				//int result2 = new BusinessMenuInfo().menuInsert(menuInfo, loginUser);
			}
			
			
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
