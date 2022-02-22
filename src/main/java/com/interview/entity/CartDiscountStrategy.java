package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

}
