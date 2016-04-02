package cn.gb.test.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gb.test.dao.TestDao;
import cn.gb.test.entity.Person;
import cn.gb.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	
	@Override
	public void say() {
		System.out.println("Hello world Test");
	}

	@Override
	public void save(Person person) {
		testDao.save(person);
		//int tem = 1/0;
	}

	@Override
	public Person findPersonById(String id) {
		save(new Person("test"));
		return testDao.findPersonById(id);
	}

}
