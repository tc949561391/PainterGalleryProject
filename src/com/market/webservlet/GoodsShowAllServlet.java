package com.market.webservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.beans.Goods;
import com.market.service.GoodsService;
import com.market.service.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsShowAllServlet
 */
@WebServlet("/GoodsShowAllServlet")
public class GoodsShowAllServlet extends HttpServlet {
	private static GoodsService service;
	
	private static final long serialVersionUID = 1L;
    static{
    	service=new GoodsServiceImpl();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Goods> goods=service.getAllGoodsInf();
		for (Goods good : goods) {
			service.goodSetProviderName(good);
		}
		
		
		
		
		request.setAttribute("goods", goods);
		
		
		request.getRequestDispatcher("/goods-all.jsp").include(request, response);
	}
	class Ngoods extends Goods{
		private String providerName;

		public String getProviderName() {
			return providerName;
		}

		public void setProviderName(String providerName) {
			this.providerName = providerName;
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
