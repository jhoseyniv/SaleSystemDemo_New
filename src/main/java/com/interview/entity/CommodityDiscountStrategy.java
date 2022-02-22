package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class CommodityDiscountStrategy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commodity_id",referencedColumnName = "id")
    @JsonIgnore
    private Commodity commodity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "discountstrategy_id", referencedColumnName = "id")
    private DiscountStrategy discountStrategy;

    @NotNull(message = "{min_number_commodity.notempty}")
    private Long minNumberOfCommdityMeetDiscount;

    public CommodityDiscountStrategy(Commodity commodity, DiscountStrategy discountStrategy, Long minNumberOfCommdityMeetDiscount) {
        this.commodity = commodity;
        this.discountStrategy = discountStrategy;
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }

    public CommodityDiscountStrategy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Long getMinNumberOfCommdityMeetDiscount() {
        return minNumberOfCommdityMeetDiscount;
    }

    public void setMinNumberOfCommdityMeetDiscount(Long minNumberOfCommdityMeetDiscount) {
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }
}
