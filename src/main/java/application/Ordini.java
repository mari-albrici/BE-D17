package application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MenuConfig;
import entities.Order;

@Component
public class Ordini implements CommandLineRunner{

	private Order order;
	private AnnotationConfigApplicationContext ctx;
	
	@Value("${application.costoCoperto}")
	double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		order = (Order) ctx.getBean("orderOne");
		
		double partialBill = order.getBill();
		double coversBill = (order.getCovers() * costoCoperto);
		System.out.println();
		System.out.println("******* ORDER: " + order.getOrderNum() + " *******");
		System.out.println("Elenco ordine: ");
		order.getOrderList().forEach((item, note) -> System.out.println(item.getName() + " - NOTE: " + note.toString()));
		System.out.println("Totale parziale: " + partialBill + "$");
		System.out.println("Totale coperti: " + coversBill + "$");
		System.out.println("Totale ordine: " + (partialBill + coversBill) + "$");
		System.out.println();
	}
}
