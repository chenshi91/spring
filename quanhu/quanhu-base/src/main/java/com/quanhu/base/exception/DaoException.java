/**Created	by	chenshi  at	2018年1月5日 下午3:06:42*/
package com.quanhu.base.exception;

/**
 * @description:	DaoException.java
 * @packageName:	com.quanhu.base.exception
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class DaoException extends RuntimeException {

	/***/
	private static final long serialVersionUID = 7048170502177113369L;
	
	private	String	message;

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
