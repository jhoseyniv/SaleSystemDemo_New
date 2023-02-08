package com.interview.service;

import com.interview.entity.Commodity;
import com.interview.entity.Customer;
import com.interview.repository.CommodityRepository;
import com.interview.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public  class CustomerService implements CustomerRepository {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public <S extends Customer> S save(S s) {
        return customerRepository.save(s);
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
//    public Flux<Customer> findAllByStream() {
//        Flux<Customer> customerFlux = Flux.fromIterable(customerRepository.findAll());
//        return customerFlux;
//    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> iterable) {
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
    public void delete(Customer customer) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
