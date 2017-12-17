
package com.quanhu.topic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {

	@Autowired
	TopicDao	topicDao;
	
	private static final long serialVersionUID = -2023936616758359946L;

	@Override
	public BaseDao<Topic> getDao() {
		return topicDao;
	}

	@Override
	public void regist(Topic topic) {
		System.out.println("-------------log---------");
	}

	

	
}
