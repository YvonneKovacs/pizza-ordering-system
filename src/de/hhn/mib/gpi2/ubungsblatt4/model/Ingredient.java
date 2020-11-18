package de.hhn.mib.gpi2.ubungsblatt4.model;

public abstract class Ingredient<T> {
    private T name;
    public void add(T name) {
        this.name = name;
    }
 }
