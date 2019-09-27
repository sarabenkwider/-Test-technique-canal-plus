package fr.altran.testCucumber.testCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"TestCode"}
		)
public class RunCucumberTest  {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

}
