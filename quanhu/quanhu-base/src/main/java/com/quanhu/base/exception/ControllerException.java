/**Created	by	chenshi  at	2018年1月6日 下午8:08:26*/
package com.quanhu.base.exception;

/**
 * @description:	ControllerException.java
 * @packageName:	com.quanhu.base.exception
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ControllerException extends RuntimeException {

	/***/
	private static final long serialVersionUID = -3619835854379460533L;
	
	private	String	message;

	/**
	 * @param message
	 */
	public ControllerException(String message) {
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
