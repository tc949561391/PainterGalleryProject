package com.market.webservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.beans.User;
import com.market.service.UserInf;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userServce;
    public LoginServlet() {
        super();
        System.out.println("init");
        userServce=new UserServiceImpl();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = null;
		String password = null;
		 userName=request.getParameter("username");
		 password=request.getParameter("password");
		if (!userName.equals("")||!password.equals("")) {
			Map<String,Object> result=userServce.login(userName, password);
			if (result.get(UserInf.LOGIN_USER_BEAN)==null) {
				//没有该用户
				request.setAttribute("logininfo", "登录失败");
				request.getRequestDispatcher("/page-login.jsp").include(request, response);
				
			}else {
				//登录成功
				HttpSession session=request.getSession();
				session.setAttribute("user",result.get(UserInf.LOGIN_USER_BEAN));
				Cookie cookie=new Cookie("username", userName);
				cookie.setMaxAge(3600);
				Cookie cookie2=new Cookie("password", password);
				cookie2.setMaxAge(3600);
				response.addCookie(cookie);
				response.addCookie(cookie2);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		
			
		}
//		
	}
	public  void loginSuccess(HttpServletRequest request,HttpServletResponse response,Map result){
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
