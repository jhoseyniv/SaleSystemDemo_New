package com.interview.repository;

import com.interview.entity.Cart;
import com.interview.entity.Commodity;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Optional<Cart> findById(Long id);
    Collection<Cart> findAll();
    Cart  findByTitle(String title);
    Collection<Cart> findByCreatedDate(ZonedDateTime createdDate);
    Collection<Cart> findByDescription(String description);
    Collection<Cart> findByDescriptionContaining(String serachTerm);

}
