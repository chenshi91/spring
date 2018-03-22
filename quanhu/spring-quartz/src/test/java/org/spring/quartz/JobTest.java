/**Created	by	chenshi  at	2018年3月21日 上午11:04:19*/
package org.spring.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.spring.quartz.job.MyJob;

/**
 * @description:	JobTest.java
 * @packageName:	org.spring.quartz
 * @projectName:	spring-quartz
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class JobTest {
	public static void main(String[] args) throws SchedulerException {
		//创建一个JobDetail实例，将该实例与MyJob绑定
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("viewJob", "group1").build();
		System.out.println("jobDetail's name :"+jobDetail.getKey().getName());
		System.out.println("jobDetail's group :"+jobDetail.getKey().getGroup());
		System.out.println("jobDetail's jobClass :"+jobDetail.getJobClass().getName());
		//创建一个Trigger实例，定义该Job立即执行，每隔2秒执行
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("aaa", "bbb")
						.startNow().withSchedule(
								SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
						.build();
		//创建Scheduler实例
		StdSchedulerFactory sfactory = new StdSchedulerFactory();
		Scheduler scheduler = sfactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
		
		
	}
}
