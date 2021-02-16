package com.kuldeep.ShedLockImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@PropertySource({"classpath:application.properties"})
public class ShedLockImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShedLockImplApplication.class, args);
	}
	
	@Bean
	public LockProvider lockProvider(DataSource dataSource) {
		return new JdbcTemplateLockProvider(dataSource);
	}

}
