package com.fruitscity.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Goodsseries entity. @author MyEclipse Persistence Tools
 */

public class Goodsseries implements java.io.Serializable {

	// Fields

	private Integer seriesId;
	private String seriesName;
	private Set goods = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goodsseries() {
	}

	/** full constructor */
	public Goodsseries(String seriesName,Set goods) {
		this.seriesName = seriesName;
		this.goods = goods;
	}

	// Property accessors

	public Integer getSeriesId() {
		return this.seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeriesName() {
		return this.seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Set getGoods() {
		return this.goods;
	}

	public void setGoods(Set goods) {
		this.goods = goods;
	}

}