package com.fruitscity.entity;

import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Orders;

/**
 * Orderdts entity. @author MyEclipse Persistence Tools
 */

public class Orderdts implements java.io.Serializable {

	// Fields

	private Integer odid;
	private Goods goods;
	private Orders orders;
	/*private Integer oid;
	private Integer goodsId;*/
	private Double goodsPrice;
	private Integer goodsCount;

	// Constructors

	/** default constructor */
	public Orderdts() {
	}

	/** full constructor */
	public Orderdts(Goods goods, Orders orders, Double goodsPrice, Integer goodsCount) {
		this.goods = goods;
		this.orders = orders;
		this.goodsPrice = goodsPrice;
		this.goodsCount = goodsCount;
	}

	// Property accessors

	public Integer getOdid() {
		return this.odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsCount() {
		return this.goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

}