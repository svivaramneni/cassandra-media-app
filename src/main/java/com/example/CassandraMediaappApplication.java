package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CassandraMediaappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(CassandraMediaappApplication.class, args);

		System.out.println("Lets inspect the beans provided by Spring Boot");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		System.out.println("-----------------------List of Beans----------------");
		for(String beanName: beanNames) {
			System.out.println(beanName);
		}
		System.out.println("-------------------------------End--------------");
	}
}
