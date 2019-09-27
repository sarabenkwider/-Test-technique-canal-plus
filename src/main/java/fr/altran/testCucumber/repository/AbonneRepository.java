package fr.altran.testCucumber.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends JpaRepository<Abonne, Integer>{
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	 Optional<Abonne> findById(int id);

}
