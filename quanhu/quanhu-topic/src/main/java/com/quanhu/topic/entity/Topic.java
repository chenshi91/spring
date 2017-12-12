
package com.quanhu.topic.entity;

import com.quanhu.base.entity.BaseEntity;

/**
 * @auter: 	chenshi 
 * @date:  	2017年11月11日 下午4:54:36
 */
public class Topic extends BaseEntity {

	private static final long serialVersionUID = 4003503744402929116L;

	private	String	title;
	
	private	String	content;
	
	private	String	imgUrl;
	

	public Topic() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Topic [" + (title != null ? "title=" + title + ", " : "")
				+ (content != null ? "content=" + content + ", " : "") + (imgUrl != null ? "imgUrl=" + imgUrl : "")
				+ "]";
	}
	
}
