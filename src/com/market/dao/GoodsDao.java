package com.market.dao;

import java.util.List;

import com.market.beans.Goods;
import com.market.beans.OutDateGoods;

/**
 * 
 * @author Tristan
 * 商品表的连接和操作
 *
 */
public interface GoodsDao {
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public boolean insertGoods(Goods goods);
	/**
	 * 删除商品
	 * @param goods
	 * @return
	 */
	public boolean deleteGoods(Goods goods);
	/**
	 * 更改商品
	 * @param goods
	 * @return
	 */
	public boolean updateGoods(Goods goods);
	/**
	 * 获得数据库中所有的商品列表
	 * @param goods
	 * @return
	 */
	public Goods querryGoods(String name);
	
	public List<Goods> getAllgoods();
	/**
	 * 获取供应商名
	 * @param goods
	 * @return
	 */
	public String getProviderName(int id);
	/**
	 * 更新商品价格
	 * @param goods
	 * @return
	 */
	public void updatePrice(Goods good);
	/**
	 * 商品出货
	 * @param goods
	 * @return
	 */
	public void outGoods(Goods good);
	/**
	 * 获取所有快过期的商品列表
	 * @param goods
	 * @return
	 */
	public List<OutDateGoods> getOutDateGoods();
}
