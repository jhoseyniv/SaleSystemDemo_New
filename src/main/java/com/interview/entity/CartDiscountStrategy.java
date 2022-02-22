package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CartDiscountStrategy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "discountStrategy_id", referencedColumnName = "id")
    @JsonIgnore
    private DiscountStrategy discountStrategy;

    @NotNull(message = "{commodity_discount.notempty}")
    private double discount;

    @NotNull(message = "{commodity_discount.notempty}")
    private Long giftId;

    public CartDiscountStrategy() {
    }

    public CartDiscountStrategy(Long id, Cart cart, DiscountStrategy discountStrategy, double discount, Long giftId) {
        this.id = id;
        this.cart = cart;
        this.discountStrategy = discountStrategy;
        this.discount = discount;
        this.giftId = giftId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }
}
