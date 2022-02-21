package com.interview.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "{firstname.notempty}")
    @Size(min = 3, message = "{firstname.length}")
    private String firstName;

    private String lastName;

    @NotEmpty(message = "{username.notempty}")
    @Size(min = 3, message = "{username.length}")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "{password.notempty}")
    @Size(min = 3, message = "{password.length}")
    private String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ShopingCart> orders;


    public Customer(String firstName, String lastName, String username, String password,Set<ShopingCart> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.orders = orders;
    }
}
