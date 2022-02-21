package com.interview.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Set;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
public class ShopingCart implements Serializable {
    static final long serialVersionUID = 1L; //assign a long value

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{order_description.notempty}")
    @Size(min = 5, message = "{order_description.length}")
    private String description;


    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<ShopingCartCommodity> cartCommodities;
    public Collection<ShopingCartCommodity> getCartCommodities() {
        return cartCommodities;
    }

    public ShopingCart(Customer customer, String description, ZonedDateTime createdDate,
                       Set<ShopingCartCommodity> cartCommodities) {
        this.description = description;
        this.createdDate = createdDate;
        this.cartCommodities = cartCommodities;
        this.customer = customer;
    }
}
