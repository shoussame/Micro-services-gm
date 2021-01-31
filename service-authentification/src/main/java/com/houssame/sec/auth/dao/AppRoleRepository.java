package com.houssame.sec.auth.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.sec.auth.entities.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
	AppRole findByRoleName(String roleName);
}
