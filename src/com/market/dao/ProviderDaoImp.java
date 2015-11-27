package com.market.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.market.beans.Provider;
import com.market.utils.UserUtils;

public class ProviderDaoImp implements ProviderDao {

	@Override
	public List<Provider> getAllProviders() {
		// TODO Auto-generated method stub
		QueryRunner runner = UserUtils.getUtils().getQueryRunner();
		List<Provider> providers = null;
		try {
			providers = runner.query("select id,name from provider", new BeanListHandler<>(Provider.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return providers;
	}
}
