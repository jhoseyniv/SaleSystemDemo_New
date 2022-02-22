package com.interview.service;

import com.interview.entity.CartStatus;
import com.interview.repository.CartStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public  class CartStatusService implements CartStatusRepository {
    @Autowired
    private CartStatusRepository cartStatusRepository;


    @Override
    public <S extends CartStatus> S save(S entity) {
        return cartStatusRepository.save(entity);
    }

    @Override
    public <S extends CartStatus> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CartStatus> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CartStatus> findAll() {
        return null;
    }

    @Override
    public Iterable<CartStatus> findAllById(Iterable<Long> longs) {
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
    public void delete(CartStatus entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CartStatus> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
