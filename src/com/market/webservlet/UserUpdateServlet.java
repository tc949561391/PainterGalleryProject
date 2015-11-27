package com.market.webservlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.User;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static UserService service;

	static {
		service = new UserServiceImpl();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
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
		List<User> users = service.getAllUsers();
		if (users.size() > 0) {
			request.setAttribute("users", users);
		}
		request.getRequestDispatcher("/user-permisstion.jsp").include(request, response);
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
			if (entry.getValue()[0].equals("manager")) {
				User user=new User();
				user.setUserName(entry.getKey());
				user.setManager(1);
				System.out.println(user.getUserName()+"   "+user.getManager());
				service.updateManager(user);
			}else if (entry.getValue()[0].equals("normal")) {
				User user=new User(); 
				user.setUserName(entry.getKey());
				user.setManager(0);
				System.out.println(user.getUserName()+"   "+user.getManager());
				service.updateManager(user);
			}

		}
		response.sendRedirect(request.getContextPath() + "/UserUpdateServlet");
	}

}
