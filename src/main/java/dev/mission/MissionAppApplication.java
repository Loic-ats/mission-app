package dev.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MissionAppApplication {

	public static void main(String[] args) {

		// Récupération du contexte Spring créé par Spring Boot
		// La classe de configuration initiale de Spring est MissionAppApplication

		ConfigurableApplicationContext context = SpringApplication.run(MissionAppApplication.class, args);

		/*
		 * 
		 * Récupération d'un bean de type Runnable On peut supprimer les lignes suivante
		 * (spécifique spring boot) si les classe du package exec implement
		 * CommandLineRunner au lieu de runnable la méthode run prend alors en parametre
		 * un tableau de string
		 * 
		 */

		Runnable exec = context.getBean(Runnable.class);

		// exécution
		exec.run();

	}

}
