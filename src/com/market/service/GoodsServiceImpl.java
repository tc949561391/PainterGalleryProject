package com.market.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.market.beans.Goods;
import com.market.dao.GoodsDao;
import com.market.dao.GoodsDaoImpl;
import com.market.utils.UserUtils;

public class GoodsServiceImpl implements GoodsService{
	private static GoodsDao goodsDao;
	public static String GOODS_ISSTOCK="ISTROCK";
	public static String GOODS_ISSALE="ISSALE";
	public static String GOODS_UPDATE_OK="updateOK";
	static{
		goodsDao=new GoodsDaoImpl();
	}

	@Override
	public List<Goods> getAllGoodsInf() {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		List<Goods> result=goodsDao.getAllgoods();
		UserUtils.getUtils().transactionCommit(conn);
		return result;
	}

	@Override
	public Map<String, Object> stockGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		Map<String, Object> result=new HashMap<>();
		Goods temp=goodsDao.querryGoods(goods.getName());
		if(temp!=null){
			temp.setCount(temp.getCount()+goods.getCount());
			if(goodsDao.updateGoods(temp)){
				result.put(GOODS_ISSTOCK, true);
			}else {
				result.put(GOODS_ISSTOCK, false);
			}
		}
		UserUtils.getUtils().transactionCommit(conn);
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, Object> saleGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		QueryRunner runner=new QueryRunner();
		try {
			conn.setAutoCommit(false);
			Goods temp=runner.query(conn, "select * from goods where id=?", new BeanHandler<>(Goods.class),goods.getId());
			if (temp.getCount()<=goods.getCount()) {
				runner.update(conn,	"delete from goods where id=?",goods.getId());
			}else{
				runner.update(conn,"update goods set count=count-? ,salednumber=salednumber+? where id =?",goods.getCount(),goods.getCount(),goods.getId());
			}
			
			conn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		Map<String, Object> result=new HashMap<>();
//		Goods temp=goodsDao.querryGoods(goods.getName());
//		if(temp!=null){
//			temp.setCount(temp.getCount()-goods.getCount());
//			if(goodsDao.updateGoods(temp)){
//				result.put(GOODS_ISSALE, true);
//			}else {
//				result.put(GOODS_ISSALE, false);
//			}
//		}
//		UserUtils.getUtils().transactionCommit(conn);
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public Map<String, Object> updatePrice(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		Map<String, Object> result=new HashMap<>();
		if(goodsDao.updateGoods(goods)){
			result.put(GOODS_UPDATE_OK,true);
		}else {
			result.put(GOODS_UPDATE_OK,false);
		}
		
		UserUtils.getUtils().transactionCommit(conn);
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Test
	public void test() {

		
	}

	@Override
	public String getProviderName(int id) {
		// TODO Auto-generated method stub
		return ""+id;
	}

	@Override
	public void goodSetProviderName(Goods good) {
		// TODO Auto-generated method stub
		good.setProviderName(getProviderName(good.getProvider_id()));
	}

}
