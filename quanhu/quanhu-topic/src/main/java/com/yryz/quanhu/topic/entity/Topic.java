
package com.yryz.quanhu.topic.entity;

import com.quanhu.base.entity.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.Max;

/**
 * @auter: 	chenshi 
 * @date:  	2017年11月11日 下午4:54:36
 */
public class Topic extends BaseEntity {

	private static final long serialVersionUID = 4003503744402929116L;

	@Max(value = 10,message = "标题最少10长度")
	private	String	title;

	@Max(value = 20,message = "内容最少20字节")
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
