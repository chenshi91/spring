/**Created	by	chenshi  at	2018年1月19日 下午6:38:20*/
package com.quanhu.base.requirements;

/**
 * @description:	ProjectRequirements.java
 * @packageName:	com.quanhu.base.requirements
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ProjectRequirements {
	
	/**话题相关需求参数*/
	public	static	interface		Topic{
		/**内容,标题的最大值和最小值*/
		public static final Byte CONTENT_LENGTH_MAX=100;
		public static final Byte CONTENT_LENGTH_MIN=5;
		public static final Byte TITLE_LENGTH_MAX=20;
		public static final Byte TITLE_LENGTH_MIN=5;
	}

}
