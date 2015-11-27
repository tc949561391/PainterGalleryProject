package com.market.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.market.beans.Goods;
import com.market.beans.Pgoods;
import com.market.dao.GoodsDao;
import com.market.dao.GoodsDaoImpl;
import com.market.utils.UserUtils;

public class OutInPutGoodsServiceImpl implements OutInPutGoodsService {
	private static GoodsDao goodsDao;
	private static GoodsService goodsService;
	int catchMoney = 0;

	static {
		goodsDao = new GoodsDaoImpl();
		goodsService = new GoodsServiceImpl();
	}

	@Override
	public Map<String, Object> outputGoods(List<Goods> goods) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		Map<String, Object> result = new HashMap<>();

		for (Goods goods2 : goods) {
			Goods temp = goodsDao.querryGoods(goods2.getName());
			if (temp != null) {// ˵����������Ʒ�б���
				if (temp.getCount() < goods2.getCount()) {// ˵��������ڳ�����ִ�г���
					goodsService.saleGoods(goods2);
					catchMoney += goods2.getCount() * goods2.getPrice();
				} else {// ˵���������ס����ȫ�����и���Ʒ���������������ݿ���ɾ��
					goodsDao.deleteGoods(goods2);
					catchMoney += temp.getCount() * temp.getPrice();
				}
			} else {// ���б���������Ʒ

			}
		}
		// �����õ�����
		result.put("catchMoney", catchMoney);
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
	public Map<String, Object> inputGoods(List<Pgoods> pgoods) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		for (Pgoods pgoods2 : pgoods) {
			Goods goods = new Goods();
			goods.setName(pgoods2.getName());
			goods.setPrice(pgoods2.getProviderprice());
			goods.setCount(pgoods2.getCount());
			goods.setProvider_id(pgoods2.getProviderid());
			goods.setProductDate(pgoods2.getProductDate());
			goods.setSaveDate(pgoods2.getSaveDate());
			System.out.println(goods.toString());
			Goods temp = goodsDao.querryGoods(pgoods2.getName());
			System.out.println("------" + temp.getName());
			goodsService.stockGoods(goods);
			if (temp.getName() != null) {
				catchMoney -= goods.getCount() * goods.getPrice();
			} else {// ���б���������Ʒ
				System.out.println("asd");
				goodsDao.insertGoods(goods);
				catchMoney -= goods.getCount() * goods.getPrice();
			}
		}
		result.put("catchMoney", catchMoney);
		return result;
	}

	@Override
	public void inputOneGoods(Pgoods pgood) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		QueryRunner runner = new QueryRunner();
		try {
			conn.setAutoCommit(false);
			Pgoods pgoodstemp = runner.query(conn, "select * from pgoods where id=?", new BeanHandler<>(Pgoods.class),
					pgood.getId());
			if (pgoodstemp.getCount() <= pgood.getCount()) {
				// 供应商的产品数量不够，将所有数量移除（删除），并将goods表的数量添加
				runner.update(conn, "delete from pgoods where id=?", pgood.getId());
			} else {
				// 数量够了
				runner.update(conn, "update pgoods set count=count-? where id=?", pgood.getCount(),pgood.getId());
				pgoodstemp.setCount(pgood.getCount());
			}
			// goods
			Goods goodtemp = runner.query(conn, "select * from goods where name=?", new BeanHandler<>(Goods.class),
					pgoodstemp.getName());
			if (goodtemp == null) {
				// 没有这个商品
				System.out.println("没有这个商品");
				runner.update(conn, "insert into goods values(null,?,?,0,?,?,?,?)", pgoodstemp.getName(),
						pgoodstemp.getCount(), pgoodstemp.getProviderid(), pgoodstemp.getProviderprice(),
						pgoodstemp.getProductDate(), pgoodstemp.getSaveDate());

			} else {
				// 有这个商品
				System.out.println("有这个商品");
				System.out.println(pgoodstemp.getCount()+":"+pgoodstemp.getName());
				runner.update(conn,"update goods set count=count+? where name=?",pgoodstemp.getCount(),pgoodstemp.getName());
			}
			conn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public Map<String, Object> updateSalePrice(List<Goods> goods) {
		// TODO Auto-generated method stub
		Connection conn = UserUtils.getUtils().getTransactionConn();
		Map<String, Object> result = new HashMap<>();
		for (Goods goods2 : goods) {
			Goods temp = goodsDao.querryGoods(goods2.getName());
			if (temp != null) {// ˵����������Ʒ�б���
				if ((boolean) goodsService.updatePrice(goods2).get(GoodsServiceImpl.GOODS_UPDATE_OK)) {
					result.put("Changeprice", true);
				}

			} else {// ���б���������Ʒ
				result.put("Changeprice", false);
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

	@Test
	public void test() {
		Goods goods = new Goods();
		goods.setCount(2);
		goods.setName("��ðҩ");
		goods.setPrice(2000000);
		Goods goods1 = new Goods();
		goods1.setName("ͷ��ҩ");
		goods1.setPrice(2);

		List<Goods> out = new ArrayList<>();
		out.add(goods);
		out.add(goods1);
		System.out.println(updateSalePrice(out).get("Changeprice").toString());
	}

}
