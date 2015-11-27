package com.market.webservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.Pgoods;
import com.market.beans.Provider;
import com.market.dao.PgoodsDao;
import com.market.dao.PgoodsDaoImpl;
import com.market.dao.ProviderDao;
import com.market.dao.ProviderDaoImp;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/StockServlet")
public class GoodsStockServlet extends HttpServlet {
	private static PgoodsDao dao;
	private static ProviderDao providerDao;

	static {
		dao = new PgoodsDaoImpl();
		providerDao = new ProviderDaoImp();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsStockServlet() {
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
		List<Pgoods> pgoodsAll = dao.getAllgoods();
		request.setAttribute("pgoods", pgoodsAll);
		request.getRequestDispatcher("/goods-stock.jsp").include(request, response);
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
