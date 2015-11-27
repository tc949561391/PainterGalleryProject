package com.market.webservlet;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.User;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;

/**
 * Servlet implementation class DoUpdateProfileServlet
 */
@WebServlet("/DoUpdateProfileServlet")
public class DoUpdateProfileServlet extends HttpServlet {
	private static UserService service;
	private static final long serialVersionUID = 1L;

	static {
		service = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUpdateProfileServlet() {
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
		String nickname = request.getParameter("nickname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCofim = request.getParameter("password1");
		int id = Integer.valueOf(request.getParameter("id"));

		if (password != "" && (password == passwordCofim || password.equals(passwordCofim))) {
			System.out.println(password + ":" + passwordCofim);
			User user = new User();
			user.setAddress(address);
			user.setPassword(password);
			user.setEmail(email);
			user.setNickName(nickname);
			user.setPhone(phone);
			user.setId(id);
			service.updateUserInformation(user);
			response.sendRedirect(request.getContextPath() + "/LogoutServlet");
			System.out.println(user.getAddress());
		} else {
			response.sendRedirect(request.getContextPath() + "/UserProfileServlet");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
// update users set password=?,manager=?,address=?,phone=?,email=?,nickname=?
// where id=? Parameters: [admin, 0, null, 中国安徽, 12323234455, demo@qq.com,
// demoName, 1]
