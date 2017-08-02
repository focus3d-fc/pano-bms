package com.focus3d.pano.test;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

public class SpringJunit4ClassRunner extends SpringJUnit4ClassRunner{
	static {
		try {
			Log4jConfigurer.initLogging("classpath:/context/log/log4j.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public SpringJunit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
 
}
