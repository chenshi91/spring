/**Created	by	chenshi  at	2017年12月26日 下午5:02:01*/
package com.quanhu.entity;

import java.io.Serializable;

/**
 * @description:	User.java
 * @packageName:	com.quanhu.entity
 * @projectName:	quanhu-spring4
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class User implements Serializable {

	/***/
	private static final long serialVersionUID = 5123413013001809129L;
	
	private	Long id;
	private	String userName;
	private String passWord;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "")
				+ (userName != null ? "userName=" + userName + ", " : "")
				+ (passWord != null ? "passWord=" + passWord : "") + "]";
	}
	/**
	 * @param id
	 * @param userName
	 * @param passWord
	 */
	public User(Long id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
	

}
