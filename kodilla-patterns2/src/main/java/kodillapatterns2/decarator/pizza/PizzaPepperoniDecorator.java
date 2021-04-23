package kodillapatterns2.decarator.pizza;

import java.math.BigDecimal;

public class PizzaPepperoniDecorator extends AbstractPizzaOrderDecorator {
    protected PizzaPepperoniDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(18));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " , Pepperoni,";
    }
}
