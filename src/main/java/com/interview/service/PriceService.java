package com.interview.service;

import com.interview.entity.Commodity;
import com.interview.entity.Price;
import com.interview.repository.CommodityRepository;
import com.interview.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public  class PriceService implements PriceRepository {
    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price findByPrice(double price) {
        return priceRepository.findByPrice(price);
    }

    @Override
    public <S extends Price> S save(S s) {
        return priceRepository.save(s);
    }

    @Override
    public <S extends Price> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Price> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Price> findAll() {
        return null;
    }

    @Override
    public Iterable<Price> findAllById(Iterable<Long> iterable) {
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
    public void delete(Price price) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Price> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
