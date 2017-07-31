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
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	/*@Override
	public List getGoodsBySeries(int goodsSeries, int page) {
		return goodsDAO.getGoodsBySeries(goodsSeries, page);
	}*/
	/*@Override
	public Pager getPagerOfGoods(int goodsSeries) {
		int count= goodsDAO.getCountOfGoods(goodsSeries);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}*/
	
	@Override
	public List getGoodsByCondition(Goods condition, int page) {		
		return goodsDAO.getGoodsByCondition(condition, page);
	}
	
	//ͳ�Ʒ��ϲ�ѯ��������Ʒ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	@Override
	public Pager getPagerOfGoods(Goods condition) {
		int count= goodsDAO.getCountOfGoods(condition);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	@Override
	public Goods getGoodsByGoodsId(int goodsId) {
		return goodsDAO.getGoodsByGoodsId(goodsId);
	}
	
	//�����Ʒ
	@Override
	public void addGoods(Goods goods) {
		goodsDAO.addGoods(goods);		
	}
	
	//ɾ��ָ�������Ʒ
	@Override
	public void deleteGoods(int goodsId) {		
		Goods goods=goodsDAO.getGoodsByGoodsId(goodsId);
		goodsDAO.deleteGoods(goods);
	}

	//�޸���Ʒ
	@Override
	public void updateGoods(Goods goods) {
		goodsDAO.updateGoods(goods);		
	}
}
