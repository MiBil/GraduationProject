package cn.gb.test;

import static org.junit.Assert.*;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gb.test.entity.Person;
import cn.gb.test.service.TestService;

public class TestMerge {

	private ClassPathXmlApplicationContext context;
	@Before
	public void loadCtx(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSpring(){
		TestService ts = (TestService) context.getBean("testService");
		ts.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("用户1"));
		transaction.commit();
		session.close();
		
	}
	
	@Test
	public void testServiceAndDao(){
		TestService ts = (TestService) context.getBean("testService");
		ts.save(new Person("用户2"));
	}
	
	@Test
	public void testTransactionReadOnly() throws Exception{
		//测试只读事务
		TestService ts = (TestService) context.getBean("testService");
		//故意在TestServiceImpl的findPerson方法中，新增一个person，即执行了写数据；
		//如果只读事务起效，那么会报出事务异常，新增的person也将失效
		Person person = ts.findPersonById("402881ef536f656b01536f656cab0000");
		System.out.println(person.getName());
	}

	@Test
	public void testTransactionRollBack() throws Exception{
		//测试事务回滚
		//故意在TestServiceImpl的save方法中，新增person后使用除以0的报错；
		//使save方法体内抛出异常信息，如果事务起效，则新增person进行回滚，也即新增person不成功
		TestService ts = (TestService) context.getBean("testService");
		ts.save(new Person("人员3"));
	}
}
