
package com.quanhu.topic.service;

import com.quanhu.base.service.BaseService;
import com.quanhu.topic.entity.Topic;

/**
 * 
 * @description:	TopicService.java
 * @packageName:	com.quanhu.topic.service
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface TopicService extends BaseService<Topic> {
	
	void regist(Topic topic);
}
