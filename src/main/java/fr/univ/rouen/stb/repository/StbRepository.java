package fr.univ.rouen.stb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univ.rouen.stb.entities.StbEntity;

@Repository
public interface StbRepository extends JpaRepository<StbEntity, Integer>{
	StbEntity findByTitleAndVersion(String title, double version);
}
