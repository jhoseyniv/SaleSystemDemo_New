package com.interview.dto.cart.builder;

public class Director {
     public  ShoppingCartBuilder shoppingCartBuilder;
    // Director knows how to use the builder and the sequence of steps.
    public void construct(ShoppingCartBuilder builder) {
            this.shoppingCartBuilder = builder;
            shoppingCartBuilder.buildHeader();
            shoppingCartBuilder.buildItem();
            shoppingCartBuilder.buildDiscount();
            shoppingCartBuilder.buildFooter();
    }
}
