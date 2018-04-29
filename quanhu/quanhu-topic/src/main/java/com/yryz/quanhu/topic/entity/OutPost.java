/**Created	by	chenshi  at	2017年12月28日 下午6:10:19*/
package com.yryz.quanhu.topic.entity;

/**
 * @description:	OutPost.java
 * @packageName:	com.quanhu.topic.post.entity
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class OutPost extends Post {
	
	/***/
	private static final long serialVersionUID = -5598300270342670165L;
	
	private	String	topicTitle;

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
}
