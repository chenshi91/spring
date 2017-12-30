
package com.quanhu.topic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.topic.entity.Topic;

/**
 * @description:	TopicDao.java
 * @packageName:	com.quanhu.topic.dao
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Repository(value="topicDao")
public interface TopicDao extends BaseDao<Topic> {
	List<Topic>		selectByTitlt(String title);	
	
}
