package com.market.webservlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.market.beans.User;

/**
 * Servlet Filter implementation class PermistionFiler
 */
@WebFilter(value = "/*")
public class PermistionFiler implements Filter {

	/**
	 * Default constructor.
	 */
	public PermistionFiler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String uri = ((HttpServletRequest) request).getRequestURI();
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(uri);
		if (user != null || uri.endsWith("LoginServlet") || uri.endsWith("RegisterServlet")
				|| uri.endsWith("page-login.jsp") || uri.endsWith("page-register.jsp")
				|| uri.indexOf("/assets/img") >= 0||uri.endsWith("index.jsp")) {
			// pass the request along the filter chain
			chain.doFilter(request, response);

		} else {

			((HttpServletRequest) request).getRequestDispatcher("/index.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
