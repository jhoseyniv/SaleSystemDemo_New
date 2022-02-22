package com.interview.repository;

import com.interview.entity.CartCommodity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartCommodityRepository extends CrudRepository<CartCommodity, Long> {

}
