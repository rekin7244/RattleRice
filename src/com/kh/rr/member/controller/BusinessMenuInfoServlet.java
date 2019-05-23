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

@WebServlet("/menuInfoUpdate.b")
public class BusinessMenuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BusinessMenuInfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메뉴업데이트 서블릿
		
		   HttpSession session = request.getSession();
	       Member loginUser = (Member)session.getAttribute("loginUser");
	       
	       String menu = request.getParameter("menu");
	       //int price = Integer.parseInt(request.getParameter("price"));
	       String price = request.getParameter("menuPrice");
	       String origin = request.getParameter("origin");
	       String mid = request.getParameter("mid");
	       //String ctn = request.getParameter("ctn");
	       System.out.println("mid : " + mid);
	       //System.out.println("ctn : "+ctn);
	     
	    	   
	       //메뉴 업데이트
	    	   StoreMenuInfo menuInfo = new StoreMenuInfo();
	    	   menuInfo.setMenu(menu);
	    	   menuInfo.setPrice(price);
	    	   menuInfo.setOrigin(origin);
	    	   menuInfo.setmId(mid);
	    	   System.out.println("메뉴인포 서블릿");
	    	   System.out.println("menuInfo : " + menuInfo);
	    	   int result = new BusinessMenuInfo().menuUpdate(menuInfo, loginUser);
	       
	    	   String page = "";
	    	   
	    	   if(result > 0) {
	    		   page = "/checkBusiness.me";
	   			request.getRequestDispatcher(page).forward(request, response);
	    	   }else {
	    		   page = "views/common/errorPage.jsp";
	   			request.setAttribute("msg", "사업자 페이지 조회실패");
	    	   }
	      
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
