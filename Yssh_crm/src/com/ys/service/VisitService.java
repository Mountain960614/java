package com.ys.service;

import com.ys.dao.VisitDao;
import com.ys.entiy.Visit;

public class VisitService {
    private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		visitDao.addVisit(visit);
	}
    
}
