package com.market.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.OutDateGoods;
import com.market.dao.GoodsDao;
import com.market.dao.GoodsDaoImpl;

/**
 * Servlet implementation class OutDateListenerServelt
 */
@WebServlet("/OutDateListenerServelt")
public class OutDateListenerServelt extends HttpServlet {
	private static GoodsDao dao;
	private static final long serialVersionUID = 1L;
       static{
    	   dao=new GoodsDaoImpl();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutDateListenerServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<OutDateGoods> outDateGoods = dao.getOutDateGoods();
		request.setAttribute("goods", outDateGoods);
		request.getRequestDispatcher("/goods-outDate.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
