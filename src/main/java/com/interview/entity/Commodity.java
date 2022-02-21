package com.interview.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
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
    private Collection<CommodityDiscountStrategy> commodity_discountStrategies;
    public Collection<CommodityDiscountStrategy> getCommodity_discountStrategies() {
        return commodity_discountStrategies;
    }

    @OneToMany(mappedBy = "commodity", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore

     private Collection<ShopingCartCommodity> commodity_orders;
     public Collection<ShopingCartCommodity> getCommodity_orders() {
        return commodity_orders;
    }

    @OneToMany(mappedBy = "price", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Price> prices;
    public Collection<Price> getPrices() {
        return prices;
    }

    public Commodity(String commditiyTitle, double price, String priceCurrency, Collection<CommodityDiscountStrategy> commodity_discountStrategies,
                     Collection<ShopingCartCommodity> commodity_orders, Collection<Price> prices) {
        this.commditiyTitle = commditiyTitle;
        this.price = price;
        this.priceCurrency = priceCurrency;
        this.commodity_discountStrategies = commodity_discountStrategies;
        this.commodity_orders = commodity_orders;
        this.prices = prices;
    }
}
