package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.BusinessService;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;

/**
 * Servlet implementation class BusinessInfoUpdate
 */
@WebServlet("/businessInfoUpdate.b")
public class BusinessInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("매장정보 업데이트 수정 서블릿 들어옹");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		
		String contact = request.getParameter("phone");
		String location = request.getParameter("address");
		String open_hore = request.getParameter("openTime1");
		String close_hore = request.getParameter("closeTime1");
		String intro = request.getParameter("introducer");
		System.out.println(loginUser.getUserId()+", "+contact+", "+location+", "+intro+", "+open_hore+", "+close_hore);
		
		StoreInfo storeUser = new StoreInfo();
		storeUser.setCotact(contact);
		storeUser.setLocation(location);
		storeUser.setOpening_hore(open_hore);
		storeUser.setClose_hore(close_hore);
		storeUser.setIntro(intro);
		storeUser.setbId(loginUser.getUserId());
		
		int result = new BusinessService().businessInfoUpdate(storeUser);
		
		String page = "";
		
		if(result > 0) {
			page="views/business/businessFormShop.jsp";
		}else {
			request.setAttribute("msg", "매장정보수정 실패");
			request.getRequestDispatcher("views/common/error.jsp");
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
