package fr.altran.testCucumber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	List<Contrat> findByAbonne(Abonne abonne);

}
