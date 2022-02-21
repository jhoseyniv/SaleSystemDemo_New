package com.interview.repository;

import com.interview.entity.Commodity;
import com.interview.entity.DiscountStrategy;
import org.springframework.data.repository.CrudRepository;

public interface DiscountStrategyRepository extends CrudRepository<DiscountStrategy, Long> {
    DiscountStrategy findByStrategyTitle(String title);

}
