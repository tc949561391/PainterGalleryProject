package com.market.webservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.User;
import com.market.service.UserInf;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        userService=new UserServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address =request.getParameter("address");
		String nickName=request.getParameter("nickname");
		Map<String, Object> result;
		int manager;
		System.out.println(request.getParameter("manager"));
		if (request.getParameter("manager")=="on"||request.getParameter("manager").equals("on")) {
			manager=1;
		}else {
			manager=0;
		}
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setManager(manager);
		user.setAddress(address);
		user.setEmail(email);
		user.setPhone(phone);
		user.setNickName(nickName);
		System.out.println(user.toString());
		if (user.getPassword().equals(request.getParameter("passwordconfim"))) {
			System.out.println("-----");
			result=userService.register(user);
			if ((boolean)result.get(UserInf.REGISTER_USERNAME_INF)) {
				response.getWriter().write("注册成功，3秒后回到登陆页面........");
				response.setHeader("refresh", "5,url="+request.getContextPath()+"/page-login.jsp");
			}else {
				request.setAttribute("registerinfo", "   ע��ʧ��");
				request.getRequestDispatcher("/page-register.jsp").include(request, response);

			}
			
		}else {
			//�������벻ͬ
			request.setAttribute("registerinfo", "   ע��ʧ��");
			request.getRequestDispatcher("/page-register.jsp").include(request, response);
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
