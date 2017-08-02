package com.focus3d.pano.test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith
(SpringJUnit4ClassRunner.class)  //使用junit4进行测试 
@ContextConfiguration
(locations={"classpath:applicationContext.xml"}) //加载配置文件  
@Transactional
public class BaseJunit4Test { 
	
}  
