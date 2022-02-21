package com.interview.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.*;

@Entity
@Data
@NoArgsConstructor

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
}
