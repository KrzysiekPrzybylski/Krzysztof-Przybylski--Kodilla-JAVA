package kodillapatterns2.decarator.pizza;

import java.math.BigDecimal;

public class PizzaClassicDecorator extends AbstractPizzaOrderDecorator {
    protected PizzaClassicDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(17));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " , maize, mushrooms";
    }
}
