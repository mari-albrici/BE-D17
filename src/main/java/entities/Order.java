package entities;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

                                                                       
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Order{

	private int orderNum;
	private OrderStatus orderStatus;
	private int covers;
	private LocalTime orderTime;
	private Map<MenuItem, String> orderList = new HashMap<>();
	
	private double bill;
	
	private Tables table;

	public Order(Tables table, int orderNum, OrderStatus orderStatus, int covers,
			LocalTime orderTime, Map<MenuItem, String> orderList, double bill) {
		this.table = table;
		this.orderNum = orderNum;
		this.orderStatus = orderStatus;
		this.covers = covers;
		this.orderTime = orderTime;
		this.orderList = orderList;
		this.bill = bill;
	} 

	
}
