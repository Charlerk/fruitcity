package com.fruitscity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.fruitscity.dao.GoodsDAO;
import com.fruitscity.entity.Goods;

public class GoodsDAOImpl implements GoodsDAO {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//获取指定页显示的商品列表
	@Override
	public List getAllGoods(int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Goods.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}

	//统计所有商品总数
	@Override
	public Integer getCountOfAllGoods() {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Goods s";
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	/*
	@Override
	public List getGoodsBySeries(int goodsSeries, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Goods.class);
		c.add(Restrictions.eq("goodsseries.seriesId", goodsSeries));
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}*/

	/*@Override
	public Integer getCountOfGoods(int goodsSeries) {
		Integer count=null;
		try{
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(s) from Goods s where goodsseries.seriesId="+goodsSeries;
		Query query=session.createQuery(hql);
		count= Integer.parseInt(query.uniqueResult().toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}*/

	@Override
	public List getGoodsByCondition(Goods condition, int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Goods.class);
		if(condition!=null){
			if(condition.getGoodsName()!=null && !condition.getGoodsName().equals("")){
				//按商品名进行筛选
				c.add(Restrictions.like("goodsName", condition.getGoodsName(),MatchMode.ANYWHERE));
			}
			if((condition.getGoodsseries()!=null) && (condition.getGoodsseries().getSeriesId()!=null)){
				//按商品类别进行筛选
				c.add(Restrictions.eq("goodsseries.seriesId", condition.getGoodsseries().getSeriesId()));
			}
		}
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}

	@Override
	public Integer getCountOfGoods(Goods condition) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Goods.class);
		if(condition!=null){
			if(condition.getGoodsName()!=null && !condition.getGoodsName().equals("")){
				//按商品名进行筛选
				c.add(Restrictions.like("goodsName", condition.getGoodsName(),MatchMode.ANYWHERE));
			}
			if((condition.getGoodsseries()!=null) && (condition.getGoodsseries().getSeriesId()!=null)){
				//按商品类别进行筛选
				c.add(Restrictions.eq("goodsseries.seriesId", condition.getGoodsseries().getSeriesId()));
			}
		}
		return c.list().size();
	}

	@Override
	public Goods getGoodsByGoodsId(int goodsId) {
		Session session=sessionFactory.getCurrentSession();
		return (Goods)session.get(Goods.class, goodsId);
	}

	//添加商品
	@Override
	public void addGoods(Goods goods) {
		Session session=sessionFactory.getCurrentSession();
		session.save(goods);
	}

	//删除商品
	@Override
	public void deleteGoods(Goods goods) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(goods);
	}

	//修改商品
	@Override
	public void updateGoods(Goods goods) {
		Session session=sessionFactory.getCurrentSession();
		session.update(goods);		
	}	
}
