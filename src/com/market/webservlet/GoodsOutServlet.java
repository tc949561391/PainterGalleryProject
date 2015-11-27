package com.market.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.market.beans.Goods;
import com.market.dao.GoodsDao;
import com.market.dao.GoodsDaoImpl;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/OutServlet")
public class GoodsOutServlet extends HttpServlet {
	private static GoodsDao dao;
	private static final long serialVersionUID = 1L;
       static{
    	   dao=new GoodsDaoImpl();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Goods> goods = dao.getAllgoods();
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("/goods-out.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
