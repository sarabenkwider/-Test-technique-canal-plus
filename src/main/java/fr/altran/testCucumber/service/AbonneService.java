package fr.altran.testCucumber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fr.altran.testCucumber.repository.Abonne;
import fr.altran.testCucumber.repository.AbonneRepository;
import fr.altran.testCucumber.repository.Contrat;
import fr.altran.testCucumber.repository.ContratRepository;

@Service
public class AbonneService {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	@Autowired
	private AbonneRepository abonneRepository;
	@Autowired
	private ContratRepository contratRepository;

	public List<Abonne> getAllAbonnes() {
		return abonneRepository.findAll();
	}

	public Abonne addAbonne(@RequestBody Abonne abonne) {
		if (abonne != null) {
		return abonneRepository.save(abonne);
		}else {
			throw new RuntimeException("L'abonne ne doit pas etre null ");
		}
	}

	public Abonne getAbonneById(@PathVariable int id) {
		return abonneRepository.findById(id).get();
	}

	public Abonne updateAdress(@RequestParam int id, @RequestParam String adress) {
		Abonne abonne = abonneRepository.findById(id).get();
		abonne.setAdress(adress);
		return abonneRepository.save(abonne);
	}

	public Contrat addContrat(@RequestBody Contrat contrat) {
		if (contrat != null) {
		return contratRepository.save(contrat);
		}else {
			throw new RuntimeException("Le contrat ne doit pas etre null ");
		}
	}

	public List<Contrat> findContratByAbonne(@RequestBody Abonne abonne) {
		return contratRepository.findByAbonne(abonne);
	}
}
