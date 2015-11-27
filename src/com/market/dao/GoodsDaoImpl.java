package com.market.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.market.beans.Goods;
import com.market.beans.OutDateGoods;
import com.market.beans.Provider;
import com.market.utils.UserUtils;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public boolean insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		int newgoods = 0;
		try {
			newgoods = runner.update("insert into goods values(null,?,?,?,?,?,?,?)", goods.getName(), goods.getCount(),
					goods.getSalednumber(), goods.getProvider_id(), goods.getPrice(), goods.getProductDate(),
					goods.getSaveDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (newgoods == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		int newgoods = 0;
		try {
			newgoods = runner.update("delete from goods where name=?", goods.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (newgoods == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateGoods(Goods goods) {
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		int newgoods = 0;

		try {
			newgoods = runner.update("update goods set count=count-?,salednumber=salednumber+? where id=?",
					goods.getCount(), goods.getCount(), goods.getId());
			System.out.println(newgoods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (newgoods == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Goods querryGoods(String name) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		Goods newgoods = new Goods();
		try {
			newgoods = runner.query("select * from goods where name=?", new BeanHandler<>(Goods.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (newgoods == null) {
			return new Goods();
		}
		return newgoods;
	}

	@Override
	public List<Goods> getAllgoods() {
		List<Goods> resultList = new ArrayList<>();
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			resultList = runner.query("select * from goods", new BeanListHandler<>(Goods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Test
	public void test() {
		List<Goods> goods = getAllgoods();
		for (Goods goods2 : goods) {
			if (goods2.getName().equals("��ðҩ")) {
				deleteGoods(goods2);
			}
		}
	}

	@Override
	public String getProviderName(int id) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		Provider provider = null;
		try {
			provider = runner.query("select * from provider where id=?", new BeanHandler<>(Provider.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provider.getName();
	}

	@Test
	public void testName() throws Exception {
		System.out.println(getOutDateGoods().size());
	}

	@Override
	public void updatePrice(Goods good) {
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			runner.update("update goods set price=? where id=?", good.getPrice(), good.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void outGoods(Goods good) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			runner.update("update goods set count=count-? where id=?", good.getCount(), good.getId());

			System.out.println("out success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<OutDateGoods> getOutDateGoods() {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		List<OutDateGoods> outDateGoods = new ArrayList<>();
		try {
			outDateGoods = runner.query(
					" select goods.*,datediff(saveDate,productDate) outDateDay"
					+ ",provider.name providername from goods,provider "
					+ "where goods.provider_id =provider.id and datediff(saveDate,productDate)<=?;",
					new BeanListHandler<>(OutDateGoods.class), 60);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outDateGoods;
	}

}
