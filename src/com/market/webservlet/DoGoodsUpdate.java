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

/**
 * Servlet implementation class DoGoodsUpdate
 */
@WebServlet("/DoGoodsUpdate")
public class DoGoodsUpdate extends HttpServlet {
	private static GoodsDao dao;
	
	private static final long serialVersionUID = 1L;
    static{
    	dao=new GoodsDaoImpl();
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoGoodsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		int id=Integer.valueOf(request.getParameter("id"));
		int price=Integer.valueOf(request.getParameter("price"));
		System.out.println(id+":" +price);
		if (id>0&&price>0) {
			
			goods.setId(id);
			goods.setPrice(price);
		}
		dao.updatePrice(goods);

		response.sendRedirect(request.getContextPath()+"/GoodsUpdateServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
