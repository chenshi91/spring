/**Created	by	chenshi  at	2017年12月28日 下午6:04:42*/
package com.yryz.quanhu.topic.service;

import java.util.List;

import com.quanhu.base.service.BaseService;
import com.yryz.quanhu.topic.entity.Post;

/**
 * @description:	PostService.java
 * @packageName:	com.quanhu.topic.post.service
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public interface PostService extends BaseService<Post> {
	
	List<Post>	postListByPage(Long topicId,Byte pageNo,Byte pageSize);

}
