package com.interview.repository;

import com.interview.entity.ShopingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Collection;

@Repository
public interface ShopingCartRepository extends CrudRepository<ShopingCart, Long> {
    ShopingCart findSaleOrderById(Long id);
    Collection<ShopingCart> findAll();
    Collection<ShopingCart> findByCreatedDate(ZonedDateTime createdDate);
    Collection<ShopingCart> findByDescription(String description);
    Collection<ShopingCart> findByDescriptionContaining(String serachTerm);

}
