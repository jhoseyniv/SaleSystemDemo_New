package com.interview.repository;

import com.interview.entity.Commodity;
import com.interview.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findByPrice(double price);
}
