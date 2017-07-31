package com.fruitscity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.fruitscity.dao.GoodsSeriesDAO;
import com.fruitscity.entity.Goods;
import com.fruitscity.entity.Goodsseries;

public class GoodsSeriesDAOImpl implements GoodsSeriesDAO {

    SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List getGoodsSeries() {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Goodsseries.class);
		return c.list();
	}

}
