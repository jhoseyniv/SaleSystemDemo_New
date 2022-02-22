package com.interview.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;


@Entity
public class Cart implements Serializable {
    static final long serialVersionUID = 1L; //assign a long value

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{order_description.notempty}")
    @Size(min = 5, message = "{order_description.length}")
    private String title;

    @NotEmpty(message = "{order_description.notempty}")
    @Size(min = 5, message = "{order_description.length}")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cartstatus_id", nullable = false)
    private CartStatus status;

    @DateTimeFormat(pattern = "dd-mmm-yyyy hh:mm:ss.s")
    private ZonedDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartCommodity> cartCommodities;
    public List<CartCommodity> getCartCommodities() {
        return cartCommodities;
    }

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartDiscountStrategy>  cartDiscountStrategies;

    public List<CartDiscountStrategy> getCartDiscountStrategies() {
        return cartDiscountStrategies;
    }

    public Cart(Customer customer, String title, String description, ZonedDateTime createdDate,
                List<CartCommodity> cartCommodities, CartStatus status,List<CartDiscountStrategy>  cartDiscountStrategies) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
        this.customer = customer;
        this.cartCommodities = cartCommodities;
        this.cartDiscountStrategies = cartDiscountStrategies;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCartCommodities(List<CartCommodity> cartCommodities) {
        this.cartCommodities = cartCommodities;
    }

    public void setCartDiscountStrategies(List<CartDiscountStrategy> cartDiscountStrategies) {
        this.cartDiscountStrategies = cartDiscountStrategies;
    }
}
