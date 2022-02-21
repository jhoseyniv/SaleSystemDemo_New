package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
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

}
