package de.hhn.mib.gpi2.ubungsblatt4.model;


import java.time.LocalDateTime;
import java.util.List;
/**
* The class where an object of type Order is created.
 * @author Yvonne Kovacs
 * */
public class Order {

    private long orderId;
    private LocalDateTime orderDate;
    private List<Pizza> pizzas;

    /**
     * Costructor of the Order class
     * @param orderId the id of the Order object
     * @param pizzas the list of pizzas
     */
    public Order(long orderId, LocalDateTime orderDate, List<Pizza> pizzas) {
        this.orderId = orderId;
        this.orderDate=orderDate;
        this.pizzas = pizzas;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    /**
     * adds a Pizza object to the pizza List
     * @param pizza Pizza object
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    /**
     * removes a Pizza object from the pizza List
     * @param pizza Pizza object
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }


}
