package com.fruitscity.dao;

import java.util.List;

import com.fruitscity.entity.Goods;

public interface GoodsDAO {
	//��ȡָ��ҳ��ʾ����Ʒ�б�
	public List getAllGoods(int page);
	
	//ͳ��������Ʒ����
	public Integer getCountOfAllGoods();
	
	//��ȡָ����Ʒ�����ָ��ҳ��ʾ����Ʒ�б�
	//public List getGoodsBySeries(int goodsSeries,int page);
	
	//ͳ��ָ����Ʒϵͳ����Ʒ����
	//public Integer getCountOfGoods(int goodsSeries);
	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ����Ʒ�б�
	public List getGoodsByCondition(Goods condition,int page);
	
	//ͳ�Ʒ��ϲ�ѯ��������Ʒ����
	public Integer getCountOfGoods(Goods condition);
	
	//���ݱ�ż�����Ʒ
	public Goods getGoodsByGoodsId(int goodsId);
	
	//�����Ʒ
	public void addGoods(Goods goods);
	
	//ɾ����Ʒ
	public void deleteGoods(Goods goods);
	
	//�޸���Ʒ����
	public void updateGoods(Goods goods);
	
}
