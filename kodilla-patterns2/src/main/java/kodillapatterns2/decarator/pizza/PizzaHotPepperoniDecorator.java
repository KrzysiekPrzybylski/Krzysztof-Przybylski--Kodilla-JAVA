package kodillapatterns2.decarator.pizza;

import java.math.BigDecimal;

public class PizzaHotPepperoniDecorator extends AbstractPizzaOrderDecorator{
    protected PizzaHotPepperoniDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(19));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", pepperoni, jalapeno, ";
    }
}
