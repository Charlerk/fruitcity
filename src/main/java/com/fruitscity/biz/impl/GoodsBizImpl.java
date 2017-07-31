package com.fruitscity.biz.impl;

import java.util.List;

import com.fruitscity.biz.GoodsBiz;
import com.fruitscity.dao.GoodsDAO;
import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Pager;

public class GoodsBizImpl implements GoodsBiz {

	GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	@Override
	public List getAllGoods(int page) {
		return goodsDAO.getAllGoods(page);
	}
	
	@Override
	public Pager getPagerOfGoods() {
		int count= goodsDAO.getCountOfAllGoods();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	
	/*@Override
	public List getGoodsBySeries(int goodsSeries, int page) {
		return goodsDAO.getGoodsBySeries(goodsSeries, page);
	}*/
	/*@Override
	public Pager getPagerOfGoods(int goodsSeries) {
		int count= goodsDAO.getCountOfGoods(goodsSeries);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}*/
	
	@Override
	public List getGoodsByCondition(Goods condition, int page) {		
		return goodsDAO.getGoodsByCondition(condition, page);
	}
	
	//统计符合查询条件的商品数量,初始化分页类Pager对象，设置perPageRows和rowCount属性
	@Override
	public Pager getPagerOfGoods(Goods condition) {
		int count= goodsDAO.getCountOfGoods(condition);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	
	@Override
	public Goods getGoodsByGoodsId(int goodsId) {
		return goodsDAO.getGoodsByGoodsId(goodsId);
	}
	
	//添加商品
	@Override
	public void addGoods(Goods goods) {
		goodsDAO.addGoods(goods);		
	}
	
	//删除指定编号商品
	@Override
	public void deleteGoods(int goodsId) {		
		Goods goods=goodsDAO.getGoodsByGoodsId(goodsId);
		goodsDAO.deleteGoods(goods);
	}

	//修改商品
	@Override
	public void updateGoods(Goods goods) {
		goodsDAO.updateGoods(goods);		
	}
}
