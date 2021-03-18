package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingItems> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    public List<ShoppingItems> getItems() {
        return new ArrayList<>(items);
    }

    public ShoppingCartBuilder add(double amount) {
        return new ShoppingCartBuilder(this, amount);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(ShoppingItems::getTotalCost).sum();
    }

    public  class ShoppingCartBuilder {
        private final ShoppingCart shoppingCart;
        private final double amount;

        public ShoppingCartBuilder(ShoppingCart shoppingCart, double amount) {
            this.shoppingCart = shoppingCart;
            this.amount = amount;
        }

        public ShoppingCart kilosOf(Fruit fruit) {
            double basePrice = shoppingCart.catalog.getPriceOf(fruit);
            double discountedPrice = (amount >= 5) ? basePrice * 0.9 : basePrice;
            ShoppingItems item = new ShoppingItems(fruit,amount,discountedPrice * amount);
            shoppingCart.items.add(item);
            return shoppingCart;
        }
    }
}
