package cn.gb.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gb.test.dao.TestDao;
import cn.gb.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findPersonById(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
