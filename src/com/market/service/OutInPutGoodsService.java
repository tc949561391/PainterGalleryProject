package com.market.service;

import java.util.List;
import java.util.Map;

import com.market.beans.Goods;
import com.market.beans.Pgoods;

public interface OutInPutGoodsService {
	/**
	 * 出货服务
	 * @param goods
	 * @return
	 */
	public Map<String, Object> outputGoods(List<Goods> goods);

	public Map<String, Object> inputGoods(List<Pgoods> Pgoods);

	public Map<String, Object> updateSalePrice(List<Goods> goods);

	public void inputOneGoods(Pgoods pgood);

}
