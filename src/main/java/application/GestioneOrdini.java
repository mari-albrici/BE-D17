package application;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MenuConfig;
import entities.Franchise;
import entities.MenuItem;
import entities.Order;
import entities.OrderStatus;
import entities.PizzaMargherita;
import entities.PizzaHawaiian;
import entities.Tables;
import entities.TableStatus;

@Component
public class GestioneOrdini implements CommandLineRunner{

	private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
	
	@Value("${application.costoCoperto}")
	double costoCoperto;
	
	Tables tableOne = new Tables(1, 4, TableStatus.RESERVED);
	Tables tableTwo =  new Tables(2, 6, TableStatus.RESERVED);

	Order orderOne() {
	    
	    Order orderA = ctx.getBean(Order.class);
	    
	    orderA.setCovers(3);
	    orderA.setTable(tableOne);
	    orderA.setOrderNum(001);
	    orderA.setOrderStatus(OrderStatus.READY);

	    Map<MenuItem, String> orderList = new LinkedHashMap<>();
	    
	    PizzaMargherita pizza = ctx.getBean(PizzaMargherita.class);
	    Franchise mug = ctx.getBean(Franchise.class);
	    
	    orderList.put(mug, "pacco regalo");
	    orderList.put(pizza, "");

	    orderA.setOrderList(orderList);

	    double bill = 0.0;

	    for (MenuItem item : orderList.keySet()) {
	        bill += item.getPrice();
	    }

	    orderA.setBill(bill);
	
	    return orderA;
	}
	
	Order orderTwo() {
	    
	    Order orderB = ctx.getBean(Order.class);
	    
	    orderB.setCovers(5);
	    orderB.setTable(tableTwo);
	    orderB.setOrderNum(002);
	    orderB.setOrderStatus(OrderStatus.PREPARING);

	    Map<MenuItem, String> orderList = new LinkedHashMap<>();
	    
	    PizzaHawaiian pizza = ctx.getBean(PizzaHawaiian.class);
	    PizzaHawaiian pizza2 = ctx.getBean(PizzaHawaiian.class);
	    PizzaHawaiian pizza3 = ctx.getBean(PizzaHawaiian.class);
	    PizzaHawaiian pizza4 = ctx.getBean(PizzaHawaiian.class);
	    PizzaHawaiian pizza5 = ctx.getBean(PizzaHawaiian.class);

	    orderList.put(pizza, "no pomodoro");
	    orderList.put(pizza2, "doppio ananas");
	    orderList.put(pizza3, "bacon no prosciutto");
	    orderList.put(pizza4, "");
	    orderList.put(pizza5, "");

	    orderB.setOrderList(orderList);

	    double bill = 0.0;

	    for (MenuItem item : orderList.keySet()) {
	        bill += item.getPrice();
	    }

	    orderB.setBill(bill);
	
	    return orderB;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		double partialBill = orderOne().getBill();
		double coversBill = (orderOne().getCovers() * costoCoperto);
		System.out.println();
		System.out.println("******* ORDER: " + orderOne().getOrderNum() + " *******");
		System.out.println("Comanda: ");
		orderOne().getOrderList().forEach((item, note) -> System.out.println(item.getName() + " - NOTE: " + note.toString()));
		System.out.println("Totale parziale: " + partialBill + "$");
		System.out.println("Totale coperti: " + coversBill + "$");
		System.out.println("Totale ordine: " + (partialBill + coversBill) + "$");
		System.out.println();
		
		double partialBill2 = orderTwo().getBill();
		double coversBill2 = (orderTwo().getCovers() * costoCoperto);
		System.out.println();
		System.out.println("******* ORDER: " + orderTwo().getOrderNum() + " *******");
		System.out.println("Comanda: ");
		orderTwo().getOrderList().forEach((item, note) -> System.out.println(item.getName() + " - NOTE: " + note.toString()));
		System.out.println("Totale parziale: " + partialBill2 + "$");
		System.out.println("Totale coperti: " + coversBill2 + "$");
		System.out.println("Totale ordine: " + (partialBill2 + coversBill2) + "$");
		System.out.println();
	}
}
