package com.interview.dto.cart.builder;

import java.time.ZonedDateTime;

public  class ShoopingCart implements ShoppingCartBuilder {
    private String title;
    private String description;
    private ZonedDateTime createdDate;

    @Override
    public void buildHeader() {

    }

    @Override
    public void buildItem() {

    }

    @Override
    public void buildDiscount() {

    }

    @Override
    public void buildFooter() {

    }
}
