package com.interview.repository;

import com.interview.entity.Commodity;
import com.interview.entity.DiscountStrategy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountStrategyRepository extends CrudRepository<DiscountStrategy, Long> {
    DiscountStrategy findByStrategyTitle(String title);

}
