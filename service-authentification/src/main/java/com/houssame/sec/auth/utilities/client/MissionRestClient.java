package com.houssame.sec.auth.utilities.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.houssame.sec.auth.utilities.prototype.Mission;

@FeignClient(name="mission-service")
public interface MissionRestClient{
    @GetMapping("/missions/professeur/{id}")
    Collection<Mission> findMissionsByProfesseurUsername(@PathVariable("username") String username);
}
