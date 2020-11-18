package de.hhn.mib.gpi2.ubungsblatt4.model;

/**
 * Pizza Tppings that can be choosen
 * @author Yvonne Kovacs
 */

public enum PizzaTopping {

    TOMATOMATO("Tomaten"),
    CHEESE("Käse"),
    SALAMI("Salami"),
    HAM("Schinken"),
    ANANAS("Ananas"),
    VEGETABLES("Gemüse"),
    SEAFOOD("Meeresfrüchte"),
    NUTELLA("Nutella"),
    SOUR_CREAM("Saure Sahne");

    private String pizzaTopping;

    PizzaTopping(String pizzaTopping) {
        this.pizzaTopping = pizzaTopping;
    }

    @Override
    public String toString() {
        return  pizzaTopping;
    }
}
