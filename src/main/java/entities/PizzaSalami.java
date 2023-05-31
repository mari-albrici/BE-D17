package entities;

import lombok.Getter;

@Getter
public class PizzaSalami extends PizzaBase {

	public PizzaSalami() {
		super("Pizza Salami (tomato, cheese, salami)", 5.99, 1160d);
	}

}
