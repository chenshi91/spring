/**Created	by	chenshi  at	2018年1月10日 下午8:09:55*/
package com.quanhu.topic;

import com.quanhu.topic.entity.Topic;

/**
 * @description:	Test.java
 * @packageName:	com.quanhu.topic
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Test extends Topic{
	/***/
	private static final long serialVersionUID = 2507503777349652449L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Test [" + (name != null ? "name=" + name : "") + "]";
	}
	public static void main(String[] args) {
		Test topic = new	Test();
		topic.setTitle("huati");
		topic.setCreateUserId("1991-7-15");
		topic.setName("chens");
		Topic	test=topic;
		System.out.println(test.toString());
	}
}
