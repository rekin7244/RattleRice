
package com.kh.rr.matching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/selectOne.cr")
public class SelectOneChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectOneChattingRoomServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		int rno = Integer.parseInt(request.getParameter("rno"));

		//방장으로 들어온건지 아닌지 판단해주는 메소드
		//룸레코드 DB에 기록이 있는지 체크한다
		int result = new ChattingRoomService().checkMasterRecord(loginUser, rno);
		
		System.out.println(result);
		if(result > 0) {
				ArrayList<HashMap<String, Object>> list = 
						new AttachmentService().selectAttachmentlList(loginUser.getUserId());
				
				request.setAttribute("list", list);
				request.getSession().setAttribute("rno", rno);
				request.getRequestDispatcher("views/matching/chatting.jsp").forward(request, response);
			
		}else {
			System.out.println("일반 사용자로 입장");
			int result2 = new ChattingRoomService().insertRoomRecord(loginUser, rno);
			
			if(result2 > 0) {
				ArrayList<HashMap<String, Object>> list = 
						new AttachmentService().selectAttachmentlList(loginUser.getUserId());
				
				//사용자가 입장 시 해당 방의 현재 인원 수 를 늘려주는 메소드
				int result3 = new ChattingRoomService().updatePperson(rno);
				
				if(result3 > 0) {
					System.out.println("인원 수 증가 성공");
				}else {
					System.out.println("인원 수 증가 실패!");
				}
				
				request.setAttribute("list", list);
				request.getSession().setAttribute("rno", rno);
				request.getRequestDispatcher("views/matching/chatting.jsp?rno=" + rno).forward(request, response);

			}else {
				request.setAttribute("msg", "채팅방 입장 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
