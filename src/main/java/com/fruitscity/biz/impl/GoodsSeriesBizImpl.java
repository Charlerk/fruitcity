package com.fruitscity.biz.impl;

import java.util.List;
import com.fruitscity.biz.GoodsSeriesBiz;
import com.fruitscity.dao.GoodsSeriesDAO;

public class GoodsSeriesBizImpl implements GoodsSeriesBiz {

	GoodsSeriesDAO goodsSeriesDAO;
	
	public void setGoodsSeriesDAO(GoodsSeriesDAO goodsSeriesDAO) {
		this.goodsSeriesDAO = goodsSeriesDAO;
	}

	@Override
	public List getGoodsSeries() {
		return goodsSeriesDAO.getGoodsSeries();
	}

}
