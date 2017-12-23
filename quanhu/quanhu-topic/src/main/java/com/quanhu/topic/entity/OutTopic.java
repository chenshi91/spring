/**Created	by	chenshi  at	2017年12月22日 下午4:58:17*/
package com.quanhu.topic.entity;

import com.quanhu.base.enums.CommonEnum;

/**
 * @description:	OutTopic.java
 * @packageName:	com.quanhu.topic.entity
 * @projectName:	quanhu-topic
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class OutTopic extends Topic {

	/***/
	private static final long serialVersionUID = 4546047660920791313L;
	
	/**枚举属性*/
	private	CommonEnum	commonEnum;

	public CommonEnum getCommonEnum() {
		return commonEnum;
	}

	public void setCommonEnum(CommonEnum commonEnum) {
		this.commonEnum = commonEnum;
	}	

}
