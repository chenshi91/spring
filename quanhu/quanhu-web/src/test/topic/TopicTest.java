
package topic;


import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quanhu.topic.entity.Topic;
import com.quanhu.topic.service.TopicService;

/**
 * @description:	TopicTest.java
 * @packageName:	topic
 * @author: 		chenshi
 * @date:			2017年11月21日 下午11:19:14	
 * @revision:   	v1.0.0
 */
public class TopicTest {
	
	private ApplicationContext ac = null;  
	
	private	TopicService	topicService=null;
	
	 @Before 
	 public void before() {  
	      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
	      topicService = (TopicService) ac.getBean("topicService");  
	 }
	 
	 @After
	 public void after(){
		 //关闭资源
		 ac = null;
		 topicService=null;
	 }
	 
	 @Test
	 public void selectById(){
		 Topic topic = topicService.selectById(710L);
		 System.out.println(topic);
	 }
	 
	 @Test
	 public void selectAll(){
		 List<Topic> list = topicService.selectAll();
		 System.out.println(list.size());
	 }
	 
	 @Test
	 public void dataSource() {
		BasicDataSource	basicDataSource=(BasicDataSource)ac.getBean("dataSource");
		String password = basicDataSource.getPassword();
		String url = basicDataSource.getUrl();
		System.out.println("password:"+password);
		System.out.println("url:"+url);
		/*act.c*/
	 }

}
