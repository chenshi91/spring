/**Created	by	chenshi  at	2017年12月5日 上午11:41:32*/
package org.quanhu.spring1.day1.entity;

/**
 * @description:	User.java
 * @packageName:	org.quanhu.spring1.day1
 * @projectName:	quanhu-spring1
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class User {
	
	private	Long id;
	
	private	String userName;
	
	private	String passWord;
	
	

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
		System.out.println("-------create    user    有参---------");
	}
	
	

	public User() {
		super();
		System.out.println("-------create    user    无参---------");
	}



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

	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "")
				+ (userName != null ? "userName=" + userName + ", " : "")
				+ (passWord != null ? "passWord=" + passWord : "") + "]";
	}
	
	
	
	
}
