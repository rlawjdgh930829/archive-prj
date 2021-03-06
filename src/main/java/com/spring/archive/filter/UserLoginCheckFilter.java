package com.spring.archive.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(value = {"/signup", "/signin"})
public class UserLoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession(false);
		boolean loginChack = false;
		if(session != null) {
			if(session.getAttribute("USER") != null) {
				loginChack = true;
			}
		}
		if(loginChack) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			request.setAttribute("ERROR", "yesLogin");
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(httpRequest, response);
		}
	}

	@Override
	public void destroy() {}

}
