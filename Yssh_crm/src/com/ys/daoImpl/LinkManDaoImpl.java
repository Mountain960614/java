package com.ys.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ys.dao.LinkManDao;
import com.ys.entiy.LinkMan;
//不添加Transactional会出现异常
@Transactional
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao   {

	@Override
	public void addForm(LinkMan linkMan) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(linkMan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> findLinkManList() {
		// TODO Auto-generated method stub
		return (List<LinkMan>) this.getHibernateTemplate()
				.find("from LinkMan");
	}
    //查询并返回一个link对象
	@Override
	public LinkMan findOne(Integer linkId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(LinkMan.class, linkId);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(linkMan);
	}

}
