package com.fruitscity.biz;

import java.util.List;

import com.fruitscity.entity.Orderdts;

public interface OrderDtsBiz {
	
	//���ɶ����ӱ�������ϸ��
    public void addOrderDts(Orderdts dts);
    
    //���ݶ��������Ż�ȡ������ϸ�б�
  	public List getOrderDtsByOid(int oid);	

}
