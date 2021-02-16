package com.kuldeep.ShedLockImpl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Component
public class Task {
	
	@Scheduled(cron = "0 1 * * * ?")
	@SchedulerLock(name = "Task_scheduledTask", lockAtLeastForString = "PT2M", lockAtMostForString = "PT10M")
	public void scheduledTask() {
		System.out.println("Counted");
	}
}
