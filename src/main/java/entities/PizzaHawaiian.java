package entities;

import lombok.Getter;

@Getter
public class PizzaHawaiian extends PizzaBase {

	public PizzaHawaiian() {
		super("Pizza Hawaiian (tomato, cheese, ham, pineapple)", 6.49, 1024d);
	}

}
