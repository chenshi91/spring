
package com.quanhu.topic.dao;

import org.apache.ibatis.annotations.Param;

import com.quanhu.topic.entity.Topic;

/**
 * @description:	TopicDao.java
 * @packageName:	com.quanhu.topic.dao
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface TopicDao {
	
	void insert(@Param("topic") Topic topic);
	Topic selectById(@Param("id")Long id);		
}
