/**Created	by	chenshi  at	2017年12月18日 上午11:50:49*/
package com.quanhu.enums;

/**
 * @description:	EnumTest.java
 * @packageName:	com.quanhu.enums
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public enum EnumTest {
	SHELVE_FLAG_ON("上架",(byte)0,"绿色"),
	SHELVE_FLAG_OFF("下架",(byte)0,"红色"),
	UN_KNUOW("未知",(byte)-1,"黑色");
	
	String name;
	Byte value;
	String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	private EnumTest(String name, Byte value, String color) {
		this.name = name;
		this.value = value;
		this.color = color;
	}
	private EnumTest() {
	}
	
	

}
