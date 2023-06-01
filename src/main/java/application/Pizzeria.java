package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pizzeria {

	public static void main(String[] args) {
		SpringApplication.run(Pizzeria.class, args);

		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		stampa.testTopping();

	}

}
