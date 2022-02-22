package com.interview.service;

import com.interview.entity.CommodityDiscountStrategy;
import com.interview.repository.CommodityDiscountStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CommodityDiscountStrategyService implements CommodityDiscountStrategyRepository {

    @Autowired
    CommodityDiscountStrategyRepository commodityDiscountStrategyRepository;

    @Override
    public <S extends CommodityDiscountStrategy> S save(S s) {
        return commodityDiscountStrategyRepository.save(s);
    }

    @Override
    public <S extends CommodityDiscountStrategy> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CommodityDiscountStrategy> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CommodityDiscountStrategy> findAll() {

        return commodityDiscountStrategyRepository.findAll();
    }

    @Override
    public Iterable<CommodityDiscountStrategy> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CommodityDiscountStrategy commodity_discountStrategy) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends CommodityDiscountStrategy> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
