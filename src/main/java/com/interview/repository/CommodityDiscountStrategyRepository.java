package com.interview.repository;

import com.interview.entity.CommodityDiscountStrategy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDiscountStrategyRepository extends CrudRepository<CommodityDiscountStrategy, Long> {

}
