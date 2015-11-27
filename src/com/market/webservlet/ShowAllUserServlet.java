package com.market.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.User;
import com.market.service.UserService;
import com.market.service.UserServiceImpl;

/**
 * Servlet implementation class ShowAllUserServlet
 */
@WebServlet("/ShowAllUserServlet")
public class ShowAllUserServlet extends HttpServlet {
	private static UserService service;
	static{
		service=new UserServiceImpl();
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users=service.getAllUsers();
		if (users.size()>0) {
			request.setAttribute("users", users);
		}
		System.out.println(users.size());
		request.getRequestDispatcher("/user-all.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
