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

@WebFilter(value = {"/commentDelete"})
public class CommentLoginCheckFilter implements Filter {

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
			chain.doFilter(httpRequest, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/signin");
			dispatcher.forward(request, response);
		}
	}

	@Override
	public void destroy() {}

}
