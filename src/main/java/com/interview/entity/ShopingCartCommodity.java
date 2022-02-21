package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class ShopingCartCommodity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "commodity_id", referencedColumnName = "id")
    @JsonProperty("commodity")
    private Commodity commodity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonIgnore
    private ShopingCart cart;

    @NotNull(message = "{number__of_commodity_orderd.notempty}")
    private Long numberOfCommodityOrdered;

    public ShopingCartCommodity(Commodity commodity, ShopingCart cart, Long numberOfCommodityOrdered) {
        this.commodity = commodity;
        this.cart = cart;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
    }
}
