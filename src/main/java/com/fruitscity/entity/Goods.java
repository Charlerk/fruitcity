package com.fruitscity.entity;

import java.util.HashSet;
import java.util.Set;

import com.fruitscity.entity.Goodsseries;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsId;
	private Goodsseries goodsseries;
	private String goodsName;
	private String goodsSummarize;
	private String goodsDescription;
	private Double goodsPrice;
	private String goodsImage;
	private Set orderdtses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(Goodsseries goodsseries, String goodsName, String goodsSummarize, String goodsDescription,
			Double goodsPrice, String goodsImage,Set orderdtses) {
		this.goodsseries = goodsseries;
		this.goodsName = goodsName;
		this.goodsSummarize = goodsSummarize;
		this.goodsDescription = goodsDescription;
		this.goodsPrice = goodsPrice;
		this.goodsImage = goodsImage;
		this.orderdtses = orderdtses;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}


	
	
	public Goodsseries getGoodsseries() {
		return this.goodsseries;
	}

	public void setGoodsseries(Goodsseries goodsseries) {
		this.goodsseries = goodsseries;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsSummarize() {
		return this.goodsSummarize;
	}

	public void setGoodsSummarize(String goodsSummarize) {
		this.goodsSummarize = goodsSummarize;
	}

	public String getGoodsDescription() {
		return this.goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public Set getOrderdtses() {
		return this.orderdtses;
	}

	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}

}