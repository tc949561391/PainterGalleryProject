package com.market.service;

import java.util.List;
import java.util.Map;

import com.market.beans.Goods;

public interface GoodsService {
	public List<Goods> getAllGoodsInf();
	/**
	 * 进货服务
	 * @param goods
	 * @return
	 */
	public Map<String, Object> stockGoods(Goods goods);
	/**
	 * 出货服务
	 * @param goods
	 * @return
	 */
	public Map<String, Object> saleGoods(Goods goods);
	/**
	 * 更新价格列表
	 * @param goods
	 * @return
	 */
	public Map<String, Object> updatePrice(Goods goods);
	/**
	 * 获取供应商
	 * @param goods
	 * @return
	 */
	public String getProviderName(int id);
	public void goodSetProviderName(Goods good);

}
