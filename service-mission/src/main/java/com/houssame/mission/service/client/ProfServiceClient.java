package com.houssame.mission.service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.houssame.mission.entities.Professeur;

@FeignClient(name = "personnel-service")
public interface ProfServiceClient {
	@GetMapping("/professeurs/{username}")
	 public Professeur findProfesseurByUsername(String username);
}
