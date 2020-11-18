package de.hhn.mib.gpi2.ubungsblatt4.model;

import java.util.List;

/**
 * The class where an object of type Pizza is created.
 * @author Yvonne Kovacs
 */

public class Pizza {
    private int price;
    private PizzaSize size;
    private List<PizzaTopping> pizzaToppings;

    /**
     * Costructor of the Pizza class
     * @param price the price of a Pizza object
     * @param size the size of a Pizza object
     * @param pizzaToppings the list of toppings
     */
    public Pizza(int price, PizzaSize size, List<PizzaTopping> pizzaToppings) {
        this.price = price;
        this.size = size;
        this.pizzaToppings = pizzaToppings;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public List<PizzaTopping> getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaToppings(List<PizzaTopping> pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                ", size=" + size +
                ", pizzaToppings=" + pizzaToppings +
                '}';
    }
}
