package com.interview.service;

import com.interview.entity.Commodity;
import com.interview.entity.DiscountStrategy;
import com.interview.repository.CommodityRepository;
import com.interview.repository.DiscountStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public  class DiscountStrategyService implements DiscountStrategyRepository {
    @Autowired
    private DiscountStrategyRepository discountStrategyRepository;


    @Override
    public DiscountStrategy findByStrategyTitle(String title) {
        return null;
    }

    @Override
    public <S extends DiscountStrategy> S save(S s) {
        return discountStrategyRepository.save(s);
    }

    @Override
    public <S extends DiscountStrategy> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<DiscountStrategy> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<DiscountStrategy> findAll() {
        return null;
    }

    @Override
    public Iterable<DiscountStrategy> findAllById(Iterable<Long> iterable) {
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
    public void delete(DiscountStrategy discountStrategy) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends DiscountStrategy> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
