
package com.quanhu.topic.entity;

import java.io.Serializable;

/**
 * @auter: 	chenshi 
 * @date:  	2017年11月11日 下午4:54:36
 */
public class Topic implements	Serializable {

	private static final long serialVersionUID = 4003503744402929116L;
	
	private Long 	id;

	private	String	title;
	
	private	String	content;
	
	private	String	imgUrl;
	

	public Topic() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Topic [" + (id != null ? "id=" + id + ", " : "") + (title != null ? "title=" + title + ", " : "")
				+ (content != null ? "content=" + content + ", " : "") + (imgUrl != null ? "imgUrl=" + imgUrl : "")
				+ "]";
	}

	

	
}
