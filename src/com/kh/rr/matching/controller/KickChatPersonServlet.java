package com.kh.rr.matching.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.member.model.vo.Member;

/**
 * Servlet implementation class KickChatPersonServlet
 */
@WebServlet("/kick.cr")
public class KickChatPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KickChatPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println("서블릿에서 가져온 유저 세션 정보 : "+loginUser);
		//방번호도 받아옴
		int rno = (int) session.getAttribute("rno");

		//방장인지 일반 사용자 인지 판별
		Member checkUser = new ChattingRoomService().checkUserType(loginUser, rno);
		
		if(checkUser.getUserId() != null ) {
			System.out.println("방장인 경우 가져온 유저정보" + checkUser);
			
		}else {
			System.out.println("방장이 아닌 경우");
			//방장 아니라면
			//이사람과 관련된 룸레코드만 지운다
			
			int result = new ChattingRoomService().deleteRoomRecord(loginUser, rno);
			
			if(result > 0) {
				System.out.println("방장 아닌 경우 룸레코드 삭제 성공");
				response.sendRedirect(request.getContextPath()+"/selectAll.cr");
			}else {
				request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
			}
			
		}
		
		/*int result = new ChattingRoomService().kickUser(userId, rno);
		
		if(result > 0) {
			System.out.println("방장인 경우 사용자 강퇴 성공");
			response.sendRedirect(request.getContextPath()+"/selectAll.cr");
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
