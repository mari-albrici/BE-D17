package entities;

import lombok.Getter;

@Getter
public class ToppingCheese extends PizzaTopping {

	public ToppingCheese(Pizza pizza) {
		super(pizza,"Cheese", 0.69, 92d);
	}

}
