/**Created	by	chenshi  at	2017年12月28日 下午6:06:04*/
package com.quanhu.topic.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.quanhu.base.dao.BaseDao;
import com.quanhu.base.enums.CommonEnum;
import com.quanhu.base.service.impl.BaseServiceImpl;
import com.quanhu.topic.dao.PostDao;
import com.quanhu.topic.dao.TopicDao;
import com.quanhu.topic.entity.Post;
import com.quanhu.topic.entity.Topic;
import com.quanhu.topic.service.PostService;

/**
 * @description:	PostServiceImpl.java
 * @packageName:	com.quanhu.topic.post.service.impl
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Service(value="postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService ,ApplicationContextAware{
	
	ApplicationContext	ac;
	/***/
	private static final long serialVersionUID = 1778323109406619391L;
	@Resource(name="postDao")
	PostDao	postDao;
	@Resource(name="topicDao")
	TopicDao	topicDao;
	
	
	@Override
	public BaseDao<Post> getDao() {
		return postDao;
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.SUPPORTS)
	@Override
	public List<Post> postListByPage(Long topicId,Byte pageNo, Byte pageSize) {
		/**1,查询是否有对应的话题存在,不存在则结束service*/
		Topic topic = topicDao.selectById(topicId);
		if(topic==null){
			return	new	ArrayList<>(0);
		}
		
		/**2,存在话题,则调用dao查询话题下帖子的集合,并且转化显示对象*/
		List<Post> postList = listByPage(pageNo, pageSize);
		for (Post post : postList) {
			post.setTopicTitle(topic.getTitle());
			if (CommonEnum.SHELVE_ON.getValue().equals(post.getShelveFlag())) {
				post.setCommonEnum(CommonEnum.SHELVE_ON);
			}else if (CommonEnum.SHELVE_OFF.getValue().equals(post.getShelveFlag())) {
				post.setCommonEnum(CommonEnum.SHELVE_OFF);
			}else {
				post.setCommonEnum(CommonEnum.UN_KNOW);
			}
		}
		return postList;
	}

	/* 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ac=arg0;
	}
	

}
