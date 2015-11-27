package com.market.dao;

import java.util.List;

import com.market.beans.Pgoods;

public interface PgoodsDao {
	public  void addOnePgoods(Pgoods pgoods);
	public List<Pgoods> getAllgoods();

	public List<Pgoods> getSomeGoodsByName(String[] names);

	public List<Pgoods> getSomeGoodsByPID(int providerId);

	public Pgoods getOneGoodsByName(String name);
}
