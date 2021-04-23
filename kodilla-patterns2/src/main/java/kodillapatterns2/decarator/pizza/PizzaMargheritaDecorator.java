package kodillapatterns2.decarator.pizza;

import java.math.BigDecimal;

public class PizzaMargheritaDecorator extends AbstractPizzaOrderDecorator {
    protected PizzaMargheritaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " maize";
    }
}
