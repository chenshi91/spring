/**Created	by	chenshi  at	2018年3月21日 上午11:00:56*/
package org.spring.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * @description:	MyJob.java
 * @packageName:	org.spring.quartz.job
 * @projectName:	spring-quartz
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//打印当前时间
		String format = new SimpleDateFormat("yyyy-MM-d H:m:s").format(Calendar.getInstance().getTime());
		System.out.println("helloword    当前时间："+format);
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("My job name and group are:"+jobKey.getName()+","+jobKey.getGroup());
		System.out.println();
	}

}
