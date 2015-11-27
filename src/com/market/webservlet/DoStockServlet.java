package com.market.webservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.Pgoods;
import com.market.dao.PgoodsDao;
import com.market.dao.PgoodsDaoImpl;
import com.market.service.OutInPutGoodsService;
import com.market.service.OutInPutGoodsServiceImpl;

/**
 * Servlet implementation class DoStockServlet
 */
@WebServlet("/DoStockServlet")
public class DoStockServlet extends HttpServlet {
	private static PgoodsDao dao;
	private static final long serialVersionUID = 1L;
	private static OutInPutGoodsService service;

	static {
		dao = new PgoodsDaoImpl();
		service=new OutInPutGoodsServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoStockServlet() {
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
		int id=Integer.valueOf(request.getParameter("id"));
		int count=Integer.valueOf(request.getParameter("count"));
		if (id>0&&count>0) {
			Pgoods pgood=new Pgoods();
			pgood.setId(id);
			pgood.setCount(count);
			service.inputOneGoods(pgood);
		}
		response.sendRedirect(request.getContextPath()+"/StockServlet");
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
