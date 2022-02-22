package com.interview.repository;

import com.interview.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.Collection;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findSaleOrderById(Long id);
    Collection<Cart> findAll();
    Collection<Cart> findByCreatedDate(ZonedDateTime createdDate);
    Collection<Cart> findByDescription(String description);
    Collection<Cart> findByDescriptionContaining(String serachTerm);

}
