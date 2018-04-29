/**Created	by	chenshi  at	2017年12月28日 下午5:59:28*/
package com.yryz.quanhu.topic.entity;

import com.quanhu.base.entity.BaseEntity;

/**
 * @description:	Post.java
 * @packageName:	com.quanhu.topic.post.entity
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Post extends BaseEntity {

	/***/
	private static final long serialVersionUID = 3739475898704279717L;
	
	private	String content;
	private	String	imgUrl;
	private	Long	topicId;
	private	String	topicTitle;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [" + (content != null ? "content=" + content + ", " : "")
				+ (imgUrl != null ? "imgUrl=" + imgUrl + ", " : "") + (topicId != null ? "topicId=" + topicId : "")
				+ "]";
	}
	

}
