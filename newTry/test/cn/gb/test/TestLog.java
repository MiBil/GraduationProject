package cn.gb.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	Log log = LogFactory.getLog(getClass());
	
	@Test
	public void test(){
		log.debug("This is debug");
		log.info("This is info");
		log.warn("This is warn");
		log.error("This is error");
		log.fatal("This is fatal");
	}
}
