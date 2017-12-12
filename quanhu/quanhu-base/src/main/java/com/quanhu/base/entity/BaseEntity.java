/**Created	by	chenshi  at	2017年12月1日 上午10:54:10*/
package com.quanhu.base.entity;

import java.util.Date;

/**
 * @description:	BaseEntity.java
 * @packageName:	com.quanhu.activie.base.entity
 * @projectName:	common-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public abstract class BaseEntity extends IdEntity {

	private static final long serialVersionUID = -5529596488497998577L;
	
	private	String	createUserId;
	
	private	String	lastUpdateUserId;
	
	private	Date	createDate;
	
	private	Date	lastUpdateDate;
	
	private	Byte	shelveFlag;
	
	private	Byte	recommend;
	
	private	Byte	revison;

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId.trim();
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Byte getRevison() {
		return revison;
	}

	public void setRevison(Byte revison) {
		this.revison = revison;
	}

	public Byte getShelveFlag() {
		return shelveFlag;
	}

	public void setShelveFlag(Byte shelveFlag) {
		this.shelveFlag = shelveFlag;
	}

	public Byte getRecommend() {
		return recommend;
	}

	public void setRecommend(Byte recommend) {
		this.recommend = recommend;
	}

	
	@Override
	public String toString() {
		return "BaseEntity ["
				+ (createUserId != null ? "createUserId=" + createUserId + ", " : "")
				+ (lastUpdateUserId != null ? "lastUpdateUserId=" + lastUpdateUserId + ", " : "")
				+ (createDate != null ? "createDate=" + createDate + ", " : "")
				+ (lastUpdateDate != null ? "lastUpdateDate=" + lastUpdateDate + ", " : "")
				+ (shelveFlag != null ? "shelveFlag=" + shelveFlag + ", " : "")
				+ (recommend != null ? "recommend=" + recommend + ", " : "")
				+ (revison != null ? "revison=" + revison : "") + "]";
	}

	
	
}
