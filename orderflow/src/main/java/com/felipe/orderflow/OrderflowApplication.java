package com.felipe.orderflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderflowApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrderflowApplication.class, args);

	}

}
