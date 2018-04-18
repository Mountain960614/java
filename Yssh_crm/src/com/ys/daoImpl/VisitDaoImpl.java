package com.ys.daoImpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ys.dao.VisitDao;
import com.ys.entiy.Visit;
@Transactional
public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	@Override
	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(visit);
	}

}
