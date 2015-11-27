package com.market.webservlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.User;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;

/**
 * Servlet implementation class UserDeleteservlet
 */
@WebServlet("/UserDeleteservlet")
public class UserDeleteservlet extends HttpServlet {
	private static UserService service;

	static {
		service = new UserServiceImpl();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");
		

		List<User> users = service.getAllUsers();
		if (users.size() > 0) {
			
			if (user!=null) {
				users.remove(user);
			}

			request.setAttribute("users", users);
		}

		request.getRequestDispatcher("/user-delete.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> params = request.getParameterMap();
		Set<Entry<String, String[]>> entrys = params.entrySet();
		for (Entry<String, String[]> entry : entrys) {
			if (entry.getKey().startsWith("delete_")) {
				System.out.println(entry.getKey().substring(7));
				service.deleteUserByUserName(entry.getKey().substring(7));
			}

		}
		response.sendRedirect(request.getContextPath()+"/UserDeleteservlet");

	}

}
