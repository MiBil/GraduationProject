package cn.gb.test.dao;

import java.io.Serializable;

import cn.gb.test.entity.Person;

public interface TestDao {
	public void save(Person person);
	
	public Person findPersonById(Serializable id);
}
