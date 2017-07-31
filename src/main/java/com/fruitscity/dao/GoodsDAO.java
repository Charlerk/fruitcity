package com.fruitscity.dao;

import java.util.List;

import com.fruitscity.entity.Goods;

public interface GoodsDAO {
	//获取指定页显示的商品列表
	public List getAllGoods(int page);
	
	//统计所有商品总数
	public Integer getCountOfAllGoods();
	
	//获取指定商品种类和指定页显示的商品列表
	//public List getGoodsBySeries(int goodsSeries,int page);
	
	//统计指定商品系统的商品总数
	//public Integer getCountOfGoods(int goodsSeries);
	
	//根据查询条件，获取指定页显示的商品列表
	public List getGoodsByCondition(Goods condition,int page);
	
	//统计符合查询条件的商品总数
	public Integer getCountOfGoods(Goods condition);
	
	//根据编号加载商品
	public Goods getGoodsByGoodsId(int goodsId);
	
	//添加商品
	public void addGoods(Goods goods);
	
	//删除商品
	public void deleteGoods(Goods goods);
	
	//修改商品对象
	public void updateGoods(Goods goods);
	
}
