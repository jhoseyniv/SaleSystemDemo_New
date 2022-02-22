package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class CartStatus implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotEmpty(message = "{order_description.notempty}")
        @Size(min = 5, message = "{order_description.length}")
        private String title;

    @OneToMany(mappedBy = "status",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Cart> carts;

    public Collection<Cart> getCarts() {
        return carts;
    }

    public CartStatus(String title) {
        this.title = title;
    }
}
