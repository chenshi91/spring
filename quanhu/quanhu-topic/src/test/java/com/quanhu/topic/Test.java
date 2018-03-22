/**Created	by	chenshi  at	2018年1月10日 下午8:09:55*/
package com.quanhu.topic;

import static com.quanhu.base.constant.CommonConstant.*;
import com.quanhu.topic.entity.Topic;

/**
 * @description: Test.java
 * @packageName: com.quanhu.topic
 * @projectName: quanhu-topic
 * @revision: v1.0.0
 * @author: chenshi
 */
public class Test extends Topic {
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
		return "Test [" + (name != null ? "name=" + name : "") + " "
				+ (super.getTitle() != null ? "title=" + super.getTitle() : "") + " "
				+ (super.getCreateUserId() != null ? "createUserId=" + super.getCreateUserId() : "") + "]";
	}

	public static void main(String[] args) {
		Topic test = new Test();
		test.setTitle("huati");
		test.setCreateUserId("1991-7-15");

		System.out.println(test);
		Test topic = (Test) test;
		topic.setName("xujiali");
		System.out.println(topic);
		String developRole = DEVELOP_ROLE;
	}
}
