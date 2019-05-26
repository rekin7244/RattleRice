package com.kh.rr.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;

/**
 * Servlet implementation class SettleReservedCheckServlet
 */
@WebServlet("/reserveSettleChecked.ad")
public class SettleReservedCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettleReservedCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strArr = request.getParameter("arr");
		String[] arr = strArr.split(",");
		
		int result = new AdminService().reserveSettleChecked(arr);
		
		if(result > 0) {
			response.sendRedirect("views/admin/b_calculate.jsp");
		}else {
			request.setAttribute("msg", "실패");
			request.getRequestDispatcher("views/common/error-500.jsp").forward(request, response);
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
