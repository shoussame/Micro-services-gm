package com.houssame.mission.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.mission.entities.Mission;

@Repository
public interface MissionRepo extends JpaRepository<Mission, String> {
	Mission findMissionById(String id);
	Optional<Mission> findByProfID(String profId);
	Optional<Mission> findByStatut(boolean statut);
}
