package com.kh.rr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.rr.wrapper.LoginWrapper;

@WebFilter("*.me")
public class EncryptFilter implements Filter {

    public EncryptFilter() {
       System.out.println("나도 객체 생성");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		
		LoginWrapper lw = new LoginWrapper(hRequest);
		
		
		//wrapper로 가공을 한 후에 하위의 httpServletRequest를 가진 Servlet으로 보내준다
		chain.doFilter(lw, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
