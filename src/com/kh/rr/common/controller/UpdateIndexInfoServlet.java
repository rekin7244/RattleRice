package com.kh.rr.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.common.model.service.IndexService;
import com.kh.rr.common.model.vo.IndexInfo;

/**
 * Servlet implementation class UpdateIndexInfoServlet
 */
@WebServlet("/updateSiteInfo.if")
public class UpdateIndexInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIndexInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intro = request.getParameter("aIntro");
		String service = request.getParameter("aService");
		
		IndexInfo info = new IndexInfo();
		info.setsInfo(intro);
		info.setsService(service);
		
		int result = new IndexService().updateSiteInfo(info);
		
		String page = "";
		if(result > 0) {
			response.sendRedirect("views/admin/updateMainForm.jsp");
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "메인페이지 정보 수정 실패!");
			request.getRequestDispatcher(page).forward(request, response);
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
