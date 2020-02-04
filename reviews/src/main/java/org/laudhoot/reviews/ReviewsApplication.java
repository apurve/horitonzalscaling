package org.laudhoot.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class ReviewsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ReviewsApplication.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
