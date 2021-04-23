package kodillapatterns2.decarator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder  implements PizzaOrder{

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(10);
    }

    @Override
    public String getDescription() {
        return "pizza with cheese, tomato sauce";
    }
}
