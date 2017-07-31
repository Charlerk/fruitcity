package com.fruitscity.dao;

import java.util.List;

import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Orders;

public interface OrdersDAO {
		
	//���ݶ�����ż��ض�������
    public Orders getOrdersByOid(int oid);
    
    //��ȡָ���û��Ķ����б�
    public List getOrdersByUserId(int userId);
    
    //��ȡָ��ҳ��ʾ�Ķ����б�
    public List getAllOrders(int page);
    
    //ͳ�����ж�������
  	public Integer getCountOfAllOrders();
    
    //��ȡ����������ָ��ҳ��ʾ�Ķ����б�
  	public List getOrdersByCondition(Orders condition,int page);
  	
  	//ͳ�Ʒ��������Ķ�������
  	public Integer getCountOfOrders(Orders condition);   
    
    
	//ɾ����������
	public void deleteOrders(Orders orders);
	
	//���¶�������
	public void updateOrders(Orders orders);		
	
}
