package kodillapatterns2.decarator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(10), calculatedCost);
    }
    @Test
    public void testBasicPizzaOrderGetDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("pizza with cheese, tomato sauce", description);
    }
    @Test
    public void testPizzaPepperoniGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaPepperoniDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(28), theCost);
    }
    @Test
    public void testPizzaPepperoniGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaPepperoniDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("pizza with cheese, tomato sauce , Pepperoni,", description);
    }
    @Test
    public void testPizzaHotPepperoniAndPizzaHavaianGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaHotPepperoniDecorator(pizzaOrder);
        PizzaOrder pizzaOrder1 = new BasicPizzaOrder();
        pizzaOrder1 = new PizzaHavaianDecorator(pizzaOrder1);
        System.out.println("Pizza Hot Pepperoni and Pizza Havaian ingredients: \npizza with cheese, tomato sauce, pepperoni, jalapeno = cost 29  \npizza with cheese, tomato sauce, pineapple and maize = cost 28");
        System.out.println();

        //When
        BigDecimal theCost = pizzaOrder.getCost();
        BigDecimal theCost1 = pizzaOrder1.getCost();
        BigDecimal sum = theCost.add(theCost1);
        //Then
        assertEquals(new BigDecimal(57), sum);
    }
    @Test
    public void testPizzaHotPepperoniAndPizzaHavaianGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PizzaHotPepperoniDecorator(pizzaOrder);
        PizzaOrder pizzaOrder1 = new BasicPizzaOrder();
        pizzaOrder1 = new PizzaHavaianDecorator(pizzaOrder1);
        System.out.println("Pizza Hot Pepperoni and Pizza Havaian ingredients: \npizza with cheese, tomato sauce, pepperoni, jalapeno \npizza with cheese, tomato sauce, pineapple and maize ");

        //When
        String description = pizzaOrder.getDescription() + pizzaOrder1.getDescription();
        //Then
        assertEquals("pizza with cheese, tomato sauce, pepperoni, jalapeno, pizza with cheese, tomato sauce, pineapple and maize ", description);
    }

}