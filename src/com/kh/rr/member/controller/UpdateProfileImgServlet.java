package com.kh.rr.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.UserInfo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/updateProImg")
public class UpdateProfileImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProfileImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		String nickName = request.getParameter("nickName");
		String msg = request.getParameter("msg");
		
		System.out.println("nickName : "+nickName);
		System.out.println("msg : "+msg);
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//전송 파일 용량 제한 : 10Mbyte로 제한
			int maxSize = 1024 * 1024 * 10;
			
			//웹 서버 컨테이너 경로 추출
			String root = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println("root : " + root);
			
			//파일 저장 경로 설정
			String filePath = root + "profileImg_upload/";
			
			
			MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//저장한 파일(변경된)의 이름을 저장할 arrayList 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일 이름을 저장할 arrayList 생성
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
				
			}
			
			//Attachment 객체 생성
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
			
		/*	UserInfo ui = new UserInfo();
			ui.setNickName(nickName);
			ui.setMsg(msg);
			ui.setUserId(loginUser.getUserId());
			int result2 = new UserInfoService().updateProfile(att, ui);*/
			
			
			int result1 = new AttachmentService().updateProfile(att, fileList);
			
			if(result1 > 0) {
				response.sendRedirect(request.getContextPath() + "/selectPro");
			}else {
				for (int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(filePath + saveFiles.get(i));
				}
				request.setAttribute("msg", "프로필이미지 수정 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
