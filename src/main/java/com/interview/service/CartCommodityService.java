package com.interview.service;

import com.interview.entity.CartCommodity;
import com.interview.repository.CartCommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartCommodityService implements CartCommodityRepository {

    @Autowired
    CartCommodityRepository  cartCommodityRepository;

    @Override
    public <S extends CartCommodity> S save(S s) {
        if(true){ // if s already in basket... order basket only will be upadate...
            return cartCommodityRepository.save(s) ;
        }
        return cartCommodityRepository.save(s);
    }

    @Override
    public <S extends CartCommodity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CartCommodity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CartCommodity> findAll() {

        return cartCommodityRepository.findAll();
    }

    @Override
    public Iterable<CartCommodity> findAllById(Iterable<Long> iterable) {
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
    public void delete(CartCommodity commodity_order) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends CartCommodity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
