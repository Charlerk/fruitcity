package com.fruitscity.dao;

import java.util.List;

import com.fruitscity.entity.Orderdts;

public interface OrderDtsDAO {
	//���ɶ����ӱ���������ϸ��
	public void addOrderDts(Orderdts dts);
	
	//���ݶ���������Ż�ȡ������ϸ�б�
	public List getOrderDtsByOid(int oid);
}