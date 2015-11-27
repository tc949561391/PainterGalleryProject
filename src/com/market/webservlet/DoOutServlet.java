package com.market.webservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.Goods;
import com.market.dao.GoodsDao;
import com.market.dao.GoodsDaoImpl;
import com.market.service.GoodsService;
import com.market.service.GoodsServiceImpl;

/**
 * Servlet implementation class DoOutServlet
 */
@WebServlet("/DoOutServlet")
public class DoOutServlet extends HttpServlet {
	private static GoodsDao dao;
	private static GoodsService service;

	static {
		dao = new GoodsDaoImpl();
		service=new GoodsServiceImpl();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoOutServlet() {
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
		Goods good=new Goods();
		int id=Integer.valueOf(request.getParameter("id"));
		int count=Integer.valueOf(request.getParameter("count"));
		if (id>0&&count>0) {
			System.out.println("---" + request.getParameter("count"));
			System.out.println("---" + request.getParameter("id"));
			good.setId(id);
			good.setCount(count);
//			dao.outGoods(good);
			service.saleGoods(good);
		}
		response.sendRedirect(request.getContextPath() + "/OutServlet");
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
