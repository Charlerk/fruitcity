package com.fruitscity.biz;

import java.util.List;

import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Pager;

public interface GoodsBiz {
	//获取指定页显示的商品列表
	public List getAllGoods(int page);
	//获取所有商品数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	public Pager getPagerOfGoods();	
	
	//获取指定菜系和指定页显示的商品列表
	//public List getGoodsBySeries(int goodsSeries,int page);
	
	//获取指定菜系的商品数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	//public Pager getPagerOfGoods(int goodsSeries);
	
	//根据查询条件，获取指定页显示的商品列表
	public List getGoodsByCondition(Goods condition,int page);
	
	//统计符合查询条件的商品数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	public Pager getPagerOfGoods(Goods condition);
	
	//根据编号加载商品
	public Goods getGoodsByGoodsId(int goodsId);
	
	//添加商品
	public void addGoods(Goods goods);
	
	//删除指定编号商品
	public void deleteGoods(int goodsId);
	
	//修改商品
	public void updateGoods(Goods goods);
	
}
