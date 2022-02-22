package com.interview.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commodity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{commodity_title.notempty}")
    private String commditiyTitle;

    @NotNull(message = "{commodity_price.notempty}")
    private double price;

    @NotEmpty(message = "{commodity_price_label.notempty}")
    private String priceCurrency;


    @OneToMany(mappedBy = "commodity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CommodityDiscountStrategy> commodityDiscountStrategies;

    public List<CommodityDiscountStrategy> getCommodityDiscountStrategies() {
        return commodityDiscountStrategies;
    }

    @OneToMany(mappedBy = "commodity", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
     private List<CartCommodity> cartCommodities;
    public List<CartCommodity> getCartCommodities() {
        return cartCommodities;
    }



    @OneToMany(mappedBy = "price", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Price> prices;
    public List<Price> getPrices() {
        return prices;
    }


    public Commodity() {
    }

    public Commodity(String commditiyTitle, double price, String priceCurrency, List<CommodityDiscountStrategy> commodityDiscountStrategies,
                     List<CartCommodity> cartCommodities, List<Price> prices) {
        this.commditiyTitle = commditiyTitle;
        this.price = price;
        this.priceCurrency = priceCurrency;
        this.commodityDiscountStrategies = commodityDiscountStrategies;
        this.cartCommodities = cartCommodities;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommditiyTitle() {
        return commditiyTitle;
    }

    public void setCommditiyTitle(String commditiyTitle) {
        this.commditiyTitle = commditiyTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public void setCommodityDiscountStrategies(List<CommodityDiscountStrategy> commodityDiscountStrategies) {
        this.commodityDiscountStrategies = commodityDiscountStrategies;
    }

    public void setCartCommodities(List<CartCommodity> cartCommodities) {
        this.cartCommodities = cartCommodities;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
