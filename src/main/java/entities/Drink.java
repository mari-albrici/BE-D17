package entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Drink implements FoodItem {
	
	private String name;
	private Double price;
	private Double calories;
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}


}
