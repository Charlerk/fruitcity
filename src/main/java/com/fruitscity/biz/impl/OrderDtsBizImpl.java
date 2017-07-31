package com.fruitscity.biz.impl;

import java.util.List;

import com.fruitscity.biz.OrderDtsBiz;
import com.fruitscity.dao.OrderDtsDAO;
import com.fruitscity.entity.Orderdts;

public class OrderDtsBizImpl implements OrderDtsBiz {

	OrderDtsDAO orderDtsDAO;	
	public void setOrderDtsDAO(OrderDtsDAO orderDtsDAO) {
		this.orderDtsDAO = orderDtsDAO;
	}
	
	//生成订单子表（订单明细）
	@Override
	public void addOrderDts(Orderdts dts) {
		orderDtsDAO.addOrderDts(dts);		
	}
	
	//根据订单主表编号获取订单明细列表
	@Override
	public List getOrderDtsByOid(int oid) {		
		return orderDtsDAO.getOrderDtsByOid(oid);
	}

}
