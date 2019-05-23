package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.board.model.service.BoardService;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/selectWrite")
public class SelectWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		
		
		int currentPage; 
		int limit;			
		int maxPage;		
		int startPage;			
		int endPage;		
		
		//페이지 수 처리용 변수
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//한 페이지에 보여질 목록 갯수
		limit = 10;
		
		//전체 목록 갯수 리턴
		int listCount = new UserInfoService().getListCount(userId);
		
		System.out.println("listCount : " + listCount);
		
		//총 페이지 수 계산
		maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 페이지에 보여줄 시작 페이지 수
		//10개씩 보여주게 할 경우
		//1, 11, 21, 31...
		startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * 10 + 1;
		
		//목록 아래쪽에 보여질 마지막 페이지 수
		//10, 20, 30
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
			
		}
		
		//페이지 정보를 공유할 vo객체 셍ㅅ
		PageInfo pi = new PageInfo(currentPage, limit, maxPage, startPage, endPage);
		
		ArrayList<Board> bList = new UserInfoService().SelectMyWrite(userId, pi);
		
		String page ="";
		if(bList != null) {
			page = "views/member/myWriteForm.jsp";
			request.setAttribute("bList", bList);
			request.setAttribute("pi", pi);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "내 작성글 조회 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
