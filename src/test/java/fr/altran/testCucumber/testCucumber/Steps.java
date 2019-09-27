package fr.altran.testCucumber.testCucumber;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.altran.testCucumber.repository.Abonne;
import fr.altran.testCucumber.service.AbonneService;

public class Steps {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	@Autowired
	AbonneService abonneService;

	@Given("^Un abonné avec une adresse principale active en France$")
	public void Un_abonné_avec_une_adresse_principale_active_en_France(Abonne abonne) throws Throwable {
		abonne = abonneService.addAbonne(abonne);
		System.out.println("________________L'abonné est bien enregistrer : " + abonne);

		throw new PendingException();
	}

	@When("^Le conseiller connecté à canal modifie l'adresse de l'abonné sans date d'effet$")
	public void Le_conseiller_connecté_à_canal_modifie_l_adresse_de_l_abonné_sans_date_d_effet(int id, String adress)
			throws Throwable {
		Abonne abonne = abonneService.updateAdress(id, adress);
		System.out.println("________________L'adresse est bien modifier : " + abonne);

		throw new PendingException();
	}

	@Then("^L'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné$")
	public void L_adresse_de_l_abonné_modifiée_est_enregistrée_sur_l_ensemble_des_contrats_de_l_abonné(Abonne abonne)
			throws Throwable {

		System.out.println("________________Les contrats d'abonné qui a modifié l'adress : "
				+ abonneService.findContratByAbonne(abonne));

		throw new PendingException();
	}

	@Then("^Un mouvement de modification d'adresse est créé$")
	public void Un_mouvement_de_modification_d_adresse_est_créé() throws Throwable {
		System.out.println("________________Le mouvement de modification est bien créé");

		throw new PendingException();
	}

}
