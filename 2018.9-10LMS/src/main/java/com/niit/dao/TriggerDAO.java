package com.niit.dao;


import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerDAO {
	
	public static void ReturnBookEmail(Date startTime) throws Exception{
	
		JobDetail job=JobBuilder.newJob(JobDAO.class).withIdentity("dummyJobName", "group1").build();
		
	
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1").startAt(startTime).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(2)).build();
		
		Scheduler scheduler =new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job,trigger);
	}

}
