package com.interview.service;

import com.interview.entity.ShopingCart;
import com.interview.repository.ShopingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public  class ShopingCartService implements ShopingCartRepository {
    @Autowired
    private ShopingCartRepository shopingCartRepository;


    @Override
    public Collection<ShopingCart> findByCreatedDate(ZonedDateTime createdDate) {
        return shopingCartRepository.findByCreatedDate(createdDate);
    }

    @Override
    public Collection<ShopingCart> findByDescription(String description) {
        return shopingCartRepository.findByDescription(description);
    }

    @Override
    public Collection<ShopingCart> findByDescriptionContaining(String serachTerm) {
        return shopingCartRepository.findByDescriptionContaining(serachTerm);
    }


    @Override
    public <S extends ShopingCart> S save(S s) {
        return shopingCartRepository.save(s);
    }

    @Override
    public <S extends ShopingCart> Iterable<S> saveAll(Iterable<S> iterable) {

        return null;
    }

    @Override
    public Optional<ShopingCart> findById(Long aLong) {
        return Optional.empty();
    }


    @Override
    public ShopingCart findSaleOrderById(Long aLong) {
        return shopingCartRepository.findSaleOrderById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Collection<ShopingCart> findAll() {

        return shopingCartRepository.findAll();
    }

    @Override
    public Iterable<ShopingCart> findAllById(Iterable<Long> iterable) {

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
    public void delete(ShopingCart order) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends ShopingCart> iterable) {

    }

    @Override
    public void deleteAll() {

    }


}
