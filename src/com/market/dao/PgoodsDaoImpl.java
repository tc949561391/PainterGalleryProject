package com.market.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.market.beans.Pgoods;
import com.market.utils.UserUtils;

public class PgoodsDaoImpl implements PgoodsDao {

	@Override
	public List<Pgoods> getAllgoods() {
		List<Pgoods> resultList = new ArrayList<>();
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			resultList = runner.query("select pgoods.*,provider.name as providername from Pgoods left join provider on pgoods.providerid=provider.id", new BeanListHandler<>(Pgoods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Pgoods> getSomeGoodsByPID(int providerId) {
		// TODO Auto-generated method stub
		List<Pgoods> resultList = new ArrayList<>();
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			resultList = runner.query("select * from pgoods where provider_id=?", new BeanListHandler<>(Pgoods.class),
					providerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<Pgoods> getSomeGoodsByName(String[] names) {
		// TODO Auto-generated method stub
		List<Pgoods> resultList = new ArrayList<>();
		for (String name : names) {
			if (getOneGoodsByName(name).getId() > 0) {
				resultList.add(getOneGoodsByName(name));
			}
		}
		return resultList;
	}

	@Override
	public Pgoods getOneGoodsByName(String name) {
		// TODO Auto-generated method stub
		Pgoods pgoods = new Pgoods();
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			pgoods = runner.query("select * from pgoods where name=?", new BeanHandler<>(Pgoods.class), name);
			System.out.println(pgoods.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pgoods;
	}

	@Test
	public void test() {

		List<Pgoods> goods = getSomeGoodsByPID(4);
		for (Pgoods pgoods : goods) {
			System.out.println(pgoods.toString());
		}
	}

	@Override
	public void addOnePgoods(Pgoods pgoods) {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		try {
			runner.insert("insert into pgoods values(null,?,?,?,?,?,?)", new BeanHandler<>(Pgoods.class),
					pgoods.getName(), pgoods.getCount(), pgoods.getProviderid(), pgoods.getProviderprice(),
					pgoods.getProductDate(), pgoods.getSaveDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testadd() {
		Pgoods pgoods = new Pgoods();
		for (int i = 1; i <= 20; i++) {
			pgoods.setCount(2000);
			pgoods.setName("food" + i);
			pgoods.setProviderid(new Random().nextInt(9) + 1);
			pgoods.setProviderprice(new Random().nextInt(30)+10);
			pgoods.setProductDate(new Date(115,new Random().nextInt(11)+1,12));
			pgoods.setSaveDate(new Date(116, 9, 9));
			addOnePgoods(pgoods);
		}

	}

}
