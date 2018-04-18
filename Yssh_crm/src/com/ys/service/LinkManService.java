package com.ys.service;

import java.util.List;

import com.ys.dao.LinkManDao;
import com.ys.entiy.LinkMan;

public class LinkManService {
  private LinkManDao linkManDao;

public void setLinkManDao(LinkManDao linkManDao) {
	this.linkManDao = linkManDao;
}

public void addForm(LinkMan linkMan) {
	// TODO Auto-generated method stub
	linkManDao.addForm(linkMan);
}

public List<LinkMan> findLinkManList() {
	// TODO Auto-generated method stub
	return linkManDao.findLinkManList();
}

public LinkMan findOne(Integer linkId) {
	// TODO Auto-generated method stub
	return linkManDao.findOne(linkId);
}

public void updateLinkMan(LinkMan linkMan) {
	// TODO Auto-generated method stub
	linkManDao.updateLinkMan(linkMan);
}
  
}
