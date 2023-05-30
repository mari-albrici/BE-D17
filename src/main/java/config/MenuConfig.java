package config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entities.Drink;
import entities.DrinkLemonade;
import entities.Franchise;
import entities.FranchiseMug;
import entities.Menu;
import entities.MenuItem;
import entities.Order;
import entities.OrderStatus;
import entities.PizzaHawaiian;
import entities.PizzaMargherita;
import entities.PizzaSalami;
import entities.Table;
import entities.TableStatus;
import entities.ToppingCheese;
import entities.ToppingHam;

@Configuration
public class MenuConfig {

	@Bean
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
	PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	Drink drinkLemonade() {
		return new DrinkLemonade();
	}
	
	@Bean
	Franchise franchiseMug() {
		return new FranchiseMug();
	}
	
	@Bean
	Table tableOne() {
		return new Table(1, 4, TableStatus.RESERVED);
	}
	
	@Bean
	Table tableTwo() {
		return new Table(2, 2, TableStatus.FREE);
	}	
	
	@Bean
	Table tableThree() {
		return new Table(3, 6, TableStatus.FREE);
	}
	
	@Bean
	Order orderOne() {
		
	    Order orderA = new Order();
	    
	    orderA.setCovers(3);
	    orderA.setTable(tableOne());
	    orderA.setOrderNum(001);
	    orderA.setOrderStatus(OrderStatus.READY);

	    Map<MenuItem, String> orderList = new LinkedHashMap<>();

	    orderList.put(pizzaMargherita(), "");
	    orderList.put(franchiseMug(), "Pacchetto regalo");

	    orderA.setOrderList(orderList);

	    double bill = 0.0;

	    for (MenuItem item : orderList.keySet()) {
	        bill += item.getPrice();
	    }

	    orderA.setBill(bill);

	    
	    return orderA;
	}
}
