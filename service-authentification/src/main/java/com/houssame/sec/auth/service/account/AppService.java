package com.houssame.sec.auth.service.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.houssame.sec.auth.utilities.client.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.houssame.sec.auth.dao.AppRoleRepository;
import com.houssame.sec.auth.dao.AppUserRepo;
import com.houssame.sec.auth.entities.AppRole;
import com.houssame.sec.auth.entities.AppUser;
import com.houssame.sec.auth.utilities.prototype.Mission;



@Transactional
@Service
public class AppService implements AccService{
	private AppRoleRepository appRoleRepository;
	private AppUserRepo appUserRepo;
	private MissionRestClient missionRestClient;
	private PasswordEncoder passwordEncoder;
	
	public AppService(AppRoleRepository appRoleRepository, AppUserRepo appUserRepo,
			MissionRestClient missionRestClient, PasswordEncoder passwordEncoder) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepo = appUserRepo;
		this.missionRestClient = missionRestClient;
	}

	public AppRole addRole (AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public AppUser addUser(AppUser appUser) {
		String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
		return appUserRepo.save(appUser);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser a = appUserRepo.findByUsername(username);
		AppRole b = appRoleRepository.findByRoleName(roleName);
		a.getRoles().add(b);
		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepo.findByUsername(username);
	}

	@Override
	public List<AppUser> listUsers() {
		// TODO Auto-generated method stub
		return appUserRepo.findAll();
	}

	@Override
	public List<AppRole> listRoles() {
		return appRoleRepository.findAll();
	}

	@Override
	public Collection<Mission> findMissionsByProfesseurUsername(String username) {
		Collection<Mission> missions = new ArrayList<>();
		try {
			missions = missionRestClient.findMissionsByProfesseurUsername(username);
		} catch (Exception e) {
			System.err.println(e);
		}
		return missions;
	}


}
