package com.interview.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Price implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{commodity_price.notempty}")
    private double price;

    @NotNull(message = "{commodity_price_type.notempty}")
    private int priceType;

    @NotEmpty(message = "{commodity_price_label.notempty}")
    private String priceLable;

    @NotNull(message = "{commodity_IsLast.notempty}")
    private boolean isLast;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commodity_id", nullable = false)
    @JsonIgnore
    private Commodity commodity;

    public Price(double price, int priceType, String priceLable, boolean isLast, Commodity commodity) {
        this.price = price;
        this.priceType = priceType;
        this.priceLable = priceLable;
        this.isLast = isLast;
        this.commodity = commodity;
    }

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriceType() {
        return priceType;
    }

    public void setPriceType(int priceType) {
        this.priceType = priceType;
    }

    public String getPriceLable() {
        return priceLable;
    }

    public void setPriceLable(String priceLable) {
        this.priceLable = priceLable;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
