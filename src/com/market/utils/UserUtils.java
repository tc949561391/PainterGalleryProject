package com.market.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserUtils {
	private static UserUtils utils = new UserUtils();

	private UserUtils() {
	}

	public static UserUtils getUtils() {
		return utils;
	}

	public QueryRunner getQueryRunner() {
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
		return runner;
	}

	public Connection getTransactionConn() {
		Connection connection = null;
		try {
			connection = new ComboPooledDataSource().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void transactionCommit(Connection conn) {
		try {
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}
