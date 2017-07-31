package com.fruitscity.entity;

import java.io.Serializable;

public class CartItemBean implements Serializable {
	private Goods goods;
	private int quantity;	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItemBean(Goods goods, int quantity) {
		this.goods = goods;
		this.quantity = quantity;
	}	

    
}
