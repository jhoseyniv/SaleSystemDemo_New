package com.interview.repository;

import com.interview.entity.Commodity;
import com.interview.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerByUsername(String username);
    //Flux<Customer> findAllByStream();
}
