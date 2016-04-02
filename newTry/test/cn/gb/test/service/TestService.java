package cn.gb.test.service;

import cn.gb.test.entity.Person;


public interface TestService {
	public void say();
	
	public void save(Person person);
	
	public Person findPersonById(String id);
}
