package com.interview.repository;

import com.interview.entity.Commodity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommodityRepository extends CrudRepository<Commodity, Long> {
    Optional<Commodity> findById(Long id);
    List<Commodity> findAll();
    Commodity  findByCommditiyTitle(String title);
    List<Commodity> findByCommditiyTitleContaining(String serachTerm);
}
