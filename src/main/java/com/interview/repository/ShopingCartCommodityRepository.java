package com.interview.repository;

import com.interview.entity.ShopingCartCommodity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopingCartCommodityRepository extends CrudRepository<ShopingCartCommodity, Long> {
}
