/***/
package com.quanhu.topic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quanhu.topic.entity.Topic;
import com.quanhu.topic.service.TopicService;

/**
 * @description:	TopicTest.java
 * @packageName:	topic
 * @author: 		chenshi
 * @date:			2017年11月21日 下午11:19:14	
 * @revision:   	v1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TopicTest {
	
	private ApplicationContext ac = null;  
	
	private	TopicService	topicService=null;
	
	 @Before  
	 public void before() {  
	      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
	      topicService = (TopicService) ac.getBean("TopicService");  
	 }
	 
	 @Test
	 public void selectById(){
		 Topic topic = topicService.selectById(1L);
		 System.out.println(topic);
	 }

}
