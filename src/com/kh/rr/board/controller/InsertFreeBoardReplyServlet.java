package com.kh.rr.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.board.model.service.BoardService;

/**
 * Servlet implementation class InsertFreeBoardReplyServlet
 */
@WebServlet("/insertFbReply.bo")
public class InsertFreeBoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFreeBoardReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		int num = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("content");
		
		int bid = new BoardService().selectfbBid(num);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		hmap.put("bid", bid); //bid
		hmap.put("writer", writer); 
		hmap.put("content", content);
		
		int result = new BoardService().insertFBR(hmap);
				
		if(result > 0) {
			ArrayList<HashMap<String, Object>> replyList = new BoardService().selectReply(bid);
			System.out.println("댓글을 달았습니다!");
			response.setContentType("application/json");
			new Gson().toJson(replyList, response.getWriter());			
		}else {
			System.out.println("댓글 달기에 실패하셨습니다..");
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
