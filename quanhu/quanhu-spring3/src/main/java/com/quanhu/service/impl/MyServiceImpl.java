/**Created	by	chenshi  at	2017年12月18日 下午12:00:56*/
package com.quanhu.service.impl;

import com.quanhu.annotations.Log;
import com.quanhu.service.MyService;

/**
 * @description:	MyServiceImpl.java
 * @packageName:	com.quanhu.service.impl
 * @projectName:	quanhu-spring3
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyServiceImpl implements MyService {

	/* 
	 * @see com.quanhu.service.MyService#login()
	 */
	@Override
	public void login() {
		System.out.println("service    login");
	}

	/* 
	 * @see com.quanhu.service.MyService#regist()
	 */
	@Override
	@Log("xyq")
	public void regist() {
		System.out.println("service    regist");
	}

	@Override
	public void m1(String name) {
		System.out.println("service    m1:name="+name);
	}

	@Override
	public void m2(String name, String value) {
		System.out.println("service    m2:name="+name+",value="+value);
	}

}
