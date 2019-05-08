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

    public EncryptFilter() {}


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest hRequest = (HttpServletRequest) request;
		
		LoginWrapper lw = new LoginWrapper(hRequest);
		
		// pass the request along the filter chain
		chain.doFilter(lw, response); //가공된 request가 넘어감
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
