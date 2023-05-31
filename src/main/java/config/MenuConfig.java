package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import entities.Drink;
import entities.DrinkLemonade;
import entities.Franchise;
import entities.FranchiseMug;
import entities.Menu;
import entities.PizzaHawaiian;
import entities.PizzaMargherita;
import entities.PizzaSalami;
import entities.ToppingCheese;
import entities.ToppingHam;

@Configuration
public class MenuConfig {

	@Bean
	@Scope("singleton")
	Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(pizzaSalami());

		menu.getMenuTopping().add(new ToppingCheese(null));
		menu.getMenuTopping().add(new ToppingHam(null));


		menu.getMenuDrink().add(drinkLemonade());
		
		

		return menu;

	}

	@Bean
	@Scope("prototype")
	PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	@Scope("prototype")
	PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	@Scope("prototype")
	PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	@Scope("prototype")
	Drink drinkLemonade() {
		return new DrinkLemonade();
	}
	
	@Bean
	@Scope("prototype")
	Franchise franchiseMug() {
		return new FranchiseMug();
	}
	
}
