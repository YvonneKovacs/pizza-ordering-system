package de.hhn.mib.gpi2.ubungsblatt4.junit;

import de.hhn.mib.gpi2.ubungsblatt4.model.Order;
import de.hhn.mib.gpi2.ubungsblatt4.model.Pizza;
import de.hhn.mib.gpi2.ubungsblatt4.model.PizzaSize;
import de.hhn.mib.gpi2.ubungsblatt4.model.PizzaTopping;
import de.hhn.mib.gpi2.ubungsblatt4.view.ImagePanel;
import de.hhn.mib.gpi2.ubungsblatt4.view.InputPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {
    private static Order order;
    private InputPanel inputPanel;
    private static final List<PizzaTopping> VALUES = Collections.unmodifiableList(Arrays.asList(PizzaTopping.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private static List<PizzaTopping> pizzaToppings;
    private List<Pizza> pizzas;

    public static PizzaTopping randomTopping()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }


    @BeforeAll
    public static void setUp(){
        ///UUID uuid = UUID.randomUUID();
       // String randomUUIDString = uuid.toString();
        List<Pizza> pizzas= new ArrayList<>();
        pizzaToppings=new ArrayList<>();
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzas.add(new Pizza(550, PizzaSize.SMALL,pizzaToppings));
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzas.add(new Pizza(650, PizzaSize.MEDIUM,pizzaToppings));
        order=new Order(1, LocalDateTime.now(), pizzas);
    }

    @Test
    public void testGetOrderId(){
        System.out.print(order.getOrderId());
        assertEquals(1, order.getOrderId());
    }


    @Test
    public void testGetDate(){
        LocalDateTime currentDate = LocalDateTime.now();
        order=new Order(2,currentDate,pizzas);
        assertEquals(LocalDateTime.now(),order.getOrderDate());
    }

    /**
     * random
     */
    @Test
    public void testGetPizzas(){
        pizzas= new ArrayList<>();
        List<PizzaTopping> pizzaToppings=new ArrayList<>();
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzas.add(new Pizza(550, PizzaSize.SMALL,pizzaToppings));
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzaToppings.add(randomTopping());
        pizzas.add(new Pizza(650, PizzaSize.MEDIUM,pizzaToppings));
        assertNotEquals(pizzas, order.getPizzas());
    }

    @Test
    public void testCheckDate(){
        LocalDateTime currentDate = LocalDateTime.now();
        ImagePanel imagePanel=new ImagePanel();
        inputPanel=new InputPanel(imagePanel);
        order=new Order(8,currentDate,pizzas);
        assertFalse(inputPanel.checkDate()==true);
    }
}
