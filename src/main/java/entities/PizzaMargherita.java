package entities;

import lombok.Getter;

@Getter
public class PizzaMargherita extends PizzaBase {

	public PizzaMargherita() {
		super("Pizza Margherita (tomato, cheese)", 4.99, 1104d);
	}

}
