/**Created	by	chenshi  at	2017年12月22日 下午4:59:27*/
package com.quanhu.base.enums;

/**
 * @description:	CommonEnum.java
 * @packageName:	com.quanhu.base.entity
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public enum CommonEnum {
	
	SHELVE_ON("上架",(byte)0,"green"),
	SHELVE_OFF("下架",(byte)1,"red"),
	RECOMMEND_ON("推荐",(byte)1),
	RECOMMEND_OFF("不推荐",(byte)0),
	UN_KNOW("未知",(byte)-1,"orange");
	String key;
	Byte value;
	String color;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Byte getValue() {
		return value;
	}
	public void setValue(Byte value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 
	 */
	private CommonEnum() {
	}
	/**
	 * @param key
	 * @param value
	 */
	private CommonEnum(String key, Byte value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * @param key
	 * @param value
	 * @param color
	 */
	private CommonEnum(String key, Byte value, String color) {
		this.key = key;
		this.value = value;
		this.color = color;
	}
	
	
}
