package com.ys.dao;

import java.util.List;

import com.ys.entiy.LinkMan;

public interface LinkManDao {

	void addForm(LinkMan linkMan);

	List<LinkMan> findLinkManList();

	LinkMan findOne(Integer linkId);

	void updateLinkMan(LinkMan linkMan);

}
