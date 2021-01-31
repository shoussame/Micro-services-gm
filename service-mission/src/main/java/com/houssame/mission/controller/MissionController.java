package com.houssame.mission.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.mission.dao.MissionRepo;
import com.houssame.mission.entities.Mission;
import com.houssame.mission.entities.Professeur;
import com.houssame.mission.service.client.ProfServiceClient;

@RestController
@CrossOrigin("http://localhost:8080")
public class MissionController {
	private MissionRepo missionRepo;
	private ProfServiceClient client;
	 public MissionController(MissionRepo missionRepo, ProfServiceClient client) {
		super();
		this.missionRepo = missionRepo;
		this.client = client;
	}
	
	    @GetMapping("/missions/profUsername/{username}")
	    Optional<Mission> getMissions(@PathVariable(name="username") String username){
	    	Professeur prof = client.findProfesseurByUsername(username);
	        Optional<Mission> mission = missionRepo.findByProfID(prof.getId());
	        return mission;
}
	    @GetMapping("/missions")
		  List<Mission> all() {
		    return missionRepo.findAll();
		  }

		  @PostMapping("/missions/add")
		  Mission newMission(@RequestBody Mission mission) {
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();
			  mission.setDateDemande(dtf.format(now));
		    return missionRepo.save(mission);
		  }

		  // Single item

		  @PostMapping("/missions/{id}")
		  Mission one(@PathVariable String id) throws Exception {
			  
		    return missionRepo.getOne(id);
		  }
		  @PostMapping("/missions/delete/{id}")
		  void deleteMission(@PathVariable String id) {
		    missionRepo.deleteById(id);
		  }
		  @PostMapping("/missions/update")
		  Mission replaceMission(@RequestBody Mission missionn) {

		    return missionRepo.findById(missionn.getId())
		      .map(mission -> {
		    	mission.setId(missionn.getId());
		        mission.setDateDepart(missionn.getDateDepart());
		        mission.setDateRetour(missionn.getDateRetour());
		        mission.setVille(missionn.getVille());
		        mission.setStatut(missionn.isStatut());
		        return missionRepo.save(mission);
		      })
		      .orElseGet(() -> {
		        missionn.setId(missionn.getId());
		        return missionRepo.save(missionn);
		      });
		  }
		  @PostMapping("missions/profId/{id}")
		  Optional<Mission> findbyPersonne(@PathVariable String id){
			  return missionRepo.findByProfID(id);
		  }
		  @PostMapping("missions/statut")
		  Optional<Mission> findByStatut(boolean staut){
			  return missionRepo.findByStatut(staut);
		  }
}
