package com.houssame.mission.service;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.mission.entities.Mission;
import com.houssame.mission.entities.Professeur;



@RestController
@CrossOrigin("http://localhost:8080")
public class MissionRest {
	@Autowired
	com.houssame.mission.dao.MissionRepo missionRepo;
	
	  
	  /*
	 
	  
	  @GetMapping("/professeur/missions")
	  Collection<Mission> getMissionsByPersonne(@RequestBody Professeur personne){
		  return missionRepo.getMissionsByPersonne(personne);
	  }
	  @GetMapping("/missions/profeseur/{id}")
	  Collection<Mission> missionByProfId(@PathVariable Long id) throws Exception {

	    return missionRepo.getMissionsByPersonne(profRepo.getOne(id));
	  }
		@GetMapping("/professeurs/missions/{idP}")
	  List<Mission> findByPersonne(@PathVariable long id){
		  return profRepo.findByPersonne(id);
	  }
	  @PostMapping("/professeur/missions/{id}")
	  Mission addMissionsByPersonneId(@RequestBody Mission mission,@PathVariable long id) {
		  Mission ms = new Mission(mission.getId(),mission.getDateDepart(), mission.getDateRetour(), mission.getDestination(), mission.isStatut());
		  ms.setPersonne(profRepo.getOne(id));
		  return missionRepo.save(ms);
	  } */

}