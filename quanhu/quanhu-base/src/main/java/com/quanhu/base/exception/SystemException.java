/**Created	by	chenshi  at	2018年1月5日 下午1:34:51*/
package com.quanhu.base.exception;

/**
 * @description:	SystemException.java
 * @packageName:	com.quanhu.base.exception
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class SystemException extends RuntimeException {
	
	/***/
	private static final long serialVersionUID = -7646497607241735018L;
	
	private	String message;

	/**
	 * @param message
	 */
	public SystemException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
