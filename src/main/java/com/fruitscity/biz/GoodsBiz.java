package com.fruitscity.biz;

import java.util.List;

import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Pager;

public interface GoodsBiz {
	//��ȡָ��ҳ��ʾ����Ʒ�б�
	public List getAllGoods(int page);
	//��ȡ������Ʒ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	public Pager getPagerOfGoods();	
	
	//��ȡָ����ϵ��ָ��ҳ��ʾ����Ʒ�б�
	//public List getGoodsBySeries(int goodsSeries,int page);
	
	//��ȡָ����ϵ����Ʒ����,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	//public Pager getPagerOfGoods(int goodsSeries);
	
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ����Ʒ�б�
	public List getGoodsByCondition(Goods condition,int page);
	
	//ͳ�Ʒ��ϲ�ѯ��������Ʒ����,��ʼ����ҳ��Pager��������perPageRows��rowCount����
	public Pager getPagerOfGoods(Goods condition);
	
	//���ݱ�ż�����Ʒ
	public Goods getGoodsByGoodsId(int goodsId);
	
	//�����Ʒ
	public void addGoods(Goods goods);
	
	//ɾ��ָ�������Ʒ
	public void deleteGoods(int goodsId);
	
	//�޸���Ʒ
	public void updateGoods(Goods goods);
	
}
