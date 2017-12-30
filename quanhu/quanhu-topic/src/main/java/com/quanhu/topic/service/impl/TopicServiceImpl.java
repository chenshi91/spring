
package com.quanhu.topic.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.service.impl.BaseServiceImpl;
import com.quanhu.topic.dao.TopicDao;
import com.quanhu.topic.entity.Topic;
import com.quanhu.topic.service.TopicService;

/**
 * 
 * @description:	TopicServiceImpl.java
 * @packageName:	com.quanhu.topic.service.impl
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Service(value="topicService")
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService,ApplicationContextAware {
	private static final long serialVersionUID = -2023936616758359946L;
	ApplicationContext	ac;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ac=arg0;
	}
	
	@Resource(name="topicDao")
	TopicDao	topicDao;
	@Override
	public BaseDao<Topic> getDao() {
		return topicDao;
	}

	@Override
	public void regist(Topic topic) {
		TopicService	topicService=(TopicService) ac.getBean("topicService");
		topicService.selectById(15L);
		System.out.println("-------------log---------");
	}

	

	

	
}
