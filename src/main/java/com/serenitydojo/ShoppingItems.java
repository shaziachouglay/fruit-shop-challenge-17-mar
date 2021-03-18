package com.serenitydojo;

public class ShoppingItems {
    private final Fruit fruit;

    public Fruit getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    private final Double quantity;
    private final Double totalCost;

    public ShoppingItems(Fruit fruit, Double quantity, Double totalCost) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }
}
