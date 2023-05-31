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
import entities.Table;
import entities.Table.TableBuilder;
import entities.TableStatus;

@Component
public class GestioneOrdini implements CommandLineRunner{

	private AnnotationConfigApplicationContext ctx;
	
	@Value("${application.costoCoperto}")
	double costoCoperto;
	
	TableBuilder tableOne = Table.builder().tableNum(1).places(4).tableStatus(TableStatus.RESERVED);

	Order orderOne() {
		
	    Order orderA = new Order();
	    
	    ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
	    
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
	}
}
