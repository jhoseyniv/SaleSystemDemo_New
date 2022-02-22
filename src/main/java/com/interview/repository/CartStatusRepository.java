package com.interview.repository;

import com.interview.entity.Cart;
import com.interview.entity.CartStatus;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

public interface CartStatusRepository extends CrudRepository<CartStatus, Long> {


}
