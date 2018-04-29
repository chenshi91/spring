
package com.yryz.quanhu.topic.service.impl;

import static com.quanhu.base.requirements.ProjectRequirements.Topic.CONTENT_LENGTH_MAX;
import static com.quanhu.base.requirements.ProjectRequirements.Topic.CONTENT_LENGTH_MIN;

import javax.annotation.Resource;

import com.quanhu.base.annotations.RedisAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.exception.ServiceException;
import com.quanhu.base.service.impl.BaseServiceImpl;
import com.yryz.quanhu.topic.dao.TopicDao;
import com.yryz.quanhu.topic.entity.Topic;
import com.yryz.quanhu.topic.service.TopicService;

/**
 * 
 * @description:	TopicServiceImpl.java
 * @packageName:	com.quanhu.topic.service.impl
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Service(value="topicService")
@Transactional
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

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void regist(Topic topic) {
		TopicService	topicService=(TopicService) ac.getBean("topicService");
		topicService.selectById(15L);
		System.out.println("-------------log---------");
		if(topic.getContent().length()>CONTENT_LENGTH_MAX||topic.getContent().length()<CONTENT_LENGTH_MIN)
			throw new ServiceException("话题内容长度在5~100之间");
	}
	
	@Override
	public	void	insert(Topic topic){
		/**1,添加参数验证条件*/
		
		/**2,调用父类没被覆盖的原方法业务*/
		super.insert(topic);
		
		/**3,扩展接口业务*/
		
	}

	@RedisAnnotation(effectiveTime = "20",returnResult = Topic.class)
	@Override
	public 	Topic selectById(Long id){
		return super.selectById(id);
	}
	

	
}
