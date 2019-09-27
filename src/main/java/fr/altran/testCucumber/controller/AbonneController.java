package fr.altran.testCucumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.altran.testCucumber.repository.Abonne;
import fr.altran.testCucumber.repository.Contrat;
import fr.altran.testCucumber.service.AbonneService;

@RestController
@RequestMapping("/listAbonnes")
public class AbonneController {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	@Autowired
	AbonneService abonneService;

	@RequestMapping(value = { "/getAllAbonnes" }, method = RequestMethod.GET)
	public List<Abonne> getAllAbonnes() {
		return abonneService.getAllAbonnes();
	}

	@RequestMapping(value = { "/addAbonne" }, method = RequestMethod.POST)
	public Abonne addAbonne(@RequestBody Abonne abonne) {
		return abonneService.addAbonne(abonne);
	}

	@RequestMapping(value = { "/getAbonneById/{id}" }, method = RequestMethod.GET)
	public Abonne getAbonneById(@PathVariable int id) {
		return abonneService.getAbonneById(id);
	}

	@RequestMapping(value = { "/updateAdress" }, method = RequestMethod.PUT)
	public Abonne updateAdress(@RequestParam int id, @RequestParam String adress) {
		return abonneService.updateAdress(id, adress);
	}

	@RequestMapping(value = { "/addContrat" }, method = RequestMethod.POST)
	public Contrat addContrat(@RequestBody Contrat contrat) {
		return abonneService.addContrat(contrat);
	}

	@RequestMapping(value = { "/getAllContratAbonne" }, method = RequestMethod.GET)
	public List<Contrat> getAllContratAbonne(@RequestBody Abonne abonne) {
		return abonneService.findContratByAbonne(abonne);
	}
}
