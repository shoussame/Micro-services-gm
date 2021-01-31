package com.houssame.sec.auth.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.sec.auth.entities.AppUser;


@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>{
	AppUser findByUsername(String username);
}
