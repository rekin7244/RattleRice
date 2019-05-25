package com.kh.rr.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;

/**
 * Servlet implementation class PointSettleServlet
 */
@WebServlet("/pSettlementOne.ad")
public class PointSettleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointSettleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("num"));
		//System.out.println(rid);
		int result = new AdminService().pSettlementOne(rid);
		
		if(result > 0) {
			response.sendRedirect("pSettlementList.ad");
		}else {
			request.setAttribute("msg", "정산 실패!");
			request.getRequestDispatcher("views/common/error-500.jsp").forward(request, response);;
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
