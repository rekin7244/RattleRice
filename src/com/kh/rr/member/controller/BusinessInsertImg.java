package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.rr.common.MyFileRenamePolicy;
import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BusinessInsertImg
 */
@WebServlet("/businessinsert.tn")
public class BusinessInsertImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessInsertImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사업자 이미지 서블릿");
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		int maxSize = 1024 * 1024 * 10;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("root : " + root);
		
		String filePath = root + "profileImg_upload/";
		
		MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize,"UTF-8", new MyFileRenamePolicy());
		
		ArrayList<String> saveFiles = new ArrayList<String>();
		
		ArrayList<String> originFiles = new ArrayList<String>();
		
		Enumeration<String> files = multiRequest.getFileNames();
		
		while(files.hasMoreElements()) {
			String name = files.nextElement();
			
			System.out.println("name : " + name);
			
			saveFiles.add(multiRequest.getFilesystemName(name));
			originFiles.add(multiRequest.getOriginalFileName(name));
			
			System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
			System.out.println("originFile : " + multiRequest.getOriginalFileName(name));
			
		}
			
			
			//Attachment객체생성
		Attachment att = new Attachment();
		att.setUserId(String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getUserId()));
		
		ArrayList<Attachment> fileList = new ArrayList<Attachment>();
		for (int i = originFiles.size() - 1 ; i >= 0; i--) {
			att.setFilePath(filePath);
			att.setOriginName(originFiles.get(i));
			att.setChangeName(saveFiles.get(i));
			att.setType("profile");
			
			fileList.add(att);
		}
		
		int result = new AttachmentService().BusinessShopImg(att, fileList);
		
		if(result > 0) {
			System.out.println("이미지 업로드 성공");
			
		}else {
			
		}
			
			
			
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
