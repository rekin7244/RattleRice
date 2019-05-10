package com.kh.rr.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.rr.common.MyFileRenamePolicy;
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.UserInfo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		System.out.println(title);
		
		//폼 전송을 multipart/form-data로 전송하는 경우에는
		//기존처럼 request.getParameter로 값을 받을 수 없다.
		//cos.jar가 파일도 받아주고 폼의 다른 값들도 받아주는 역할을 한다.
		//com.orelilly.servlet의 약자이다.
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//System.out.println("multipart로 requset 요청");
			//전송 파일 용량 제한 : 10Mbyte로 제한
			int maxSize = 1024 * 1024 * 10;
			
			//웹 서버 컨테이너 경로 추출
			String root = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println("root : " + root);
			
			//파일 저장 경로 설정
			String filePath = root + "thumbnail_upload/";
			
			//객체를 생성할 때 부터 파일을 저장하고 그에 대한 정보를 가져오는 형태이다.
			//즉 파일의 정보를 검사하여 저장하는 형태가 아닌, 저장한 다음 검사 후 삭제를 해야 한다.
			
			//사용자가 올린 파일명을 그대로 저장하지 않는 것이 일반적이다.
			//1. 같은 파일명이 있는 경우 이전 파일을 덮어 쓸 수 있다.
			//2. 한글로 된 파일명, 특수기호, 띄어쓰기 등은 서버에 따라 문제가 생길 수 도 있다.
			//DefaultFileRenamePolicy는 cos.jar 안에 존재하는 클래스로
			//같은 파일명이 존재하는지를 검사하고 있을 경우에는 파일명 뒤에 숫자를 붙여준다.
			//ex : aaa.zip, aaa1.zip, aaa2.zip, ....
			//MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//저장한 파일(변경된)의 이름을 저장할 arrayList 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일 이름을 저장할 arrayList 생성
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
			
			//UserInfo객체 생성
			UserInfo ui = new UserInfo();
			ui.setUserId(String.valueOf(((UserInfo)(request.getSession().getAttribute("loginUser"))).getUserId()));
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for (int i = originFiles.size() - 1 ; i >= 0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(filePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				fileList.add(at);
			}
			
			int result = new UserInfoService().updateProfile(ui, fileList);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectProfile");
			}else {
				for (int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(filePath + saveFiles.get(i));
					
					//true false 리턴됨
					System.out.println(failedFile.delete());
				}
				request.setAttribute("msg", "프로필 수정 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
