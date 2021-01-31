package com.houssame.sec.auth.service.personne;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.sec.auth.dao.ProfesseurRepo;
import com.houssame.sec.auth.entities.Professeur;
import com.houssame.sec.auth.utilities.client.MissionRestClient;
import com.houssame.sec.auth.utilities.prototype.Mission;

@RestController
@CrossOrigin("http://localhost:8080")
public class ProfesseurRestService {
	private ProfesseurRepo profRepo;
	private MissionRestClient missionRestClient;

	public ProfesseurRestService(ProfesseurRepo profRepo) {
		super();
		this.profRepo = profRepo;
		this.missionRestClient = missionRestClient;
	}
	@GetMapping("/professeurs")
	@PreAuthorize("hasAuthority('MODERATOR')")
	public List<Professeur> getProfesseus(@PathVariable(name="username") String username){
			return profRepo.findAll();
	        }
	@GetMapping("/professeur/{username}")
	@PreAuthorize("hasAuthority('USER')")
	public Professeur getProfesseurByUsername(@PathVariable(name="username") String username){
			Collection<Mission> missions = missionRestClient.findMissionsByProfesseurUsername(username);
			Professeur prof = profRepo.findByUsername(username);
			prof.setMissions(missions);
			return prof;
	        }
	/*
	@GetMapping("/personnes/missions/{id}")
	public Professeur getProfesseurMission(@PathVariable(name="username") String username){
			Professeur prof=profRepo.findByUsername(username);
	        prof.getMissions().add((Mission) missionRestClient.findByProfesseurUsername(prof.getUsername()));
	        prof.getMissions().forEach(a -> prof.getMissions().add(a) );
	        return prof;
	        }
	        */
}
