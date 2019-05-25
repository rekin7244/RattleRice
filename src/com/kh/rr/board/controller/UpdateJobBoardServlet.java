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
 * Servlet implementation class UpdateJobBoardServlet
 */
@WebServlet("/jobBoardUpdate.bo")
public class UpdateJobBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("jbT");
		String content = request.getParameter("jbCon");
		
		System.out.println("게시글 번호 : " + num);
		System.out.println("제목 : " + title);		
		System.out.println("내용 : " + content);
		
		Board jb = new Board();
		
		jb.setTitle(title);
		jb.setbContent(content);
		
		int result = new BoardService().updateJobBoard(num, jb);
		
		if(result > 0) {
			System.out.println("게시글 수정 성공!!");
		}else {
			System.out.println("게시글 수정 실패!");
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
