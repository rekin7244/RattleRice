package com.kh.rr.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.board.model.service.BoardService;
import com.kh.rr.board.model.vo.Board;

/**
 * Servlet implementation class InsertFreeBoardServlet
 */
@WebServlet("/freeBoardInsert.bo")
public class InsertFreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFreeBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("fbUserId");
		String title = request.getParameter("fbTitle");
		String content = request.getParameter("fbContent");
		
		System.out.println("유저아이디 : " + userId);
		System.out.println("제목 : " + title);		
		System.out.println("내용 : " + content);
		
		Board fb = new Board();
		
		fb.setWriter(userId);
		fb.setTitle(title);
		fb.setbContent(content);
		
		int result = new BoardService().insertFreeBoard(fb);
		 
		if(result > 0) {
			System.out.println("게시글 등록 성공!!");
		}else {
			System.out.println("게시글 등록 실패!");
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
