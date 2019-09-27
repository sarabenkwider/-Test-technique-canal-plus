package fr.altran.testCucumber;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import fr.altran.testCucumber.repository.Abonne;
import fr.altran.testCucumber.repository.Contrat;
import fr.altran.testCucumber.service.AbonneService;

@SpringBootApplication
@EnableJpaAuditing
public class TestCucumberApplication implements CommandLineRunner {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	@Autowired
	AbonneService abonneService;

	public static void main(String[] args) {
		SpringApplication.run(TestCucumberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Ajouter un abonne
		Abonne a = new Abonne("Sara", "Paris");
		a=abonneService.addAbonne(a);
		System.out.println("___________" + a);

		// Modifier l'adressed'un abonne
		a = abonneService.updateAdress(a.getId(), "Lion");
		System.out.println("___________" + a);

		// System.out.println("___________" + a1.getCreatedDate());
		// System.out.println("___________" + a1.getCreatedBy());

		// Ajouter des contrats
		abonneService.getAllAbonnes().forEach(abonne -> {
			for (int i = 0; i < 4; i++)
				abonneService
						.addContrat(new Contrat("Contrat " + i + " d'abonnement avec canal +", new Date(), abonne));
		});

		// La liste des contrat pour d'un abonne
		abonneService.findContratByAbonne(a).forEach(contrat -> {
			System.out.println("___________" + contrat);
		});

	}

}
