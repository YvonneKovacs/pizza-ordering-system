package de.hhn.mib.gpi2.ubungsblatt4.model;

import de.hhn.mib.gpi2.ubungsblatt4.i18n.I18N;

/**
 * Pizza Sizes, that can be choosen
 * @author Yvonne Kovacs
 */

public enum PizzaSize {
    SMALL("Klein",4),
    MEDIUM("Mittel",5),
    LARGE("Groß",7),
    EXTRA_LARGE("Extra-Groß",10);

    private String pizzaSize;

    private int pizzaPrice;

    /**
     * Costructor of the PizzaSize class
     * @param pizzaSize the pizza size of a Pizza object
     * @param pizzaPrice the price of a Pizza object
     */
    PizzaSize(String pizzaSize, int pizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.pizzaPrice = pizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setPizzaPrice(int pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public String toString() {
        if(this.equals(PizzaSize.SMALL))
            return I18N.getMessage("small");
        return pizzaSize;
    }
}
