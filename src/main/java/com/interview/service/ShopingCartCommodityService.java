package com.interview.service;

import com.interview.entity.ShopingCartCommodity;
import com.interview.repository.ShopingCartCommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ShopingCartCommodityService implements ShopingCartCommodityRepository {

    @Autowired
    ShopingCartCommodityRepository shopingCartCommodityRepository;

    public <S extends ShopingCartCommodity> S save(S s) {
        if(true){ // if s already in basket... order basket only will be upadate...
            return shopingCartCommodityRepository.save(s) ;
        }
        return shopingCartCommodityRepository.save(s);
    }

    @Override
    public <S extends ShopingCartCommodity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ShopingCartCommodity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ShopingCartCommodity> findAll() {

        return shopingCartCommodityRepository.findAll();
    }

    @Override
    public Iterable<ShopingCartCommodity> findAllById(Iterable<Long> iterable) {
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
    public void delete(ShopingCartCommodity commodity_order) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends ShopingCartCommodity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
