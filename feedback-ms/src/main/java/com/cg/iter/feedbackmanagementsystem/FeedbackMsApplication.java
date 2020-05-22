package com.cg.iter.feedbackmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeedbackMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackMsApplication.class, args);
	}

}
