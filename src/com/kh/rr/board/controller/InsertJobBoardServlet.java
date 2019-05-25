package com.kh.rr.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.board.model.service.BoardService;
import com.kh.rr.board.model.vo.Board;

/**
 * Servlet implementation class InsertJobBoardServlet
 */
@WebServlet("/JobBoardInsert.bo")
public class InsertJobBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertJobBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("jbUserId");
		String title = request.getParameter("jbTitle");
		String content = request.getParameter("jbContent");
		String jbCategory = request.getParameter("jbCategory");
		
		System.out.println("유저아이디 : " + userId);
		System.out.println("제목 : " + title);		
		System.out.println("내용 : " + content);
		System.out.println("카테고리 : " + jbCategory);
		
		Board jb = new Board();
		
		jb.setWriter(userId);
		jb.setTitle(title);
		jb.setbContent(content);
		jb.setjCategory(jbCategory);
		
		int result = new BoardService().insertJobBoard(jb);
		 
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
