/**Created	by	chenshi  at	2017年12月28日 下午6:03:33*/
package com.yryz.quanhu.topic.dao;

import com.yryz.quanhu.topic.entity.Post;
import org.springframework.stereotype.Repository;

import com.quanhu.base.dao.BaseDao;

/**
 * @description:	PostDao.java
 * @packageName:	com.quanhu.topic.post.dao
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Repository(value="postDao")
public interface PostDao extends BaseDao<Post> {

}
