package com.houssame.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMissionApplication.class, args);
	}

}
