package com.interview.service;

import com.interview.entity.Cart;
import com.interview.entity.CartCommodity;
import com.interview.entity.Commodity;
import com.interview.repository.CartCommodityRepository;
import com.interview.repository.CartRepository;
import com.interview.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class CartCommodityService implements CartCommodityRepository {

    @Autowired
    CartCommodityRepository  cartCommodityRepository;
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CommodityRepository commodityRepository;

    public  CartCommodity saveorUpdate(String cartTitle,String commoitytitle, Long numberOfCommodity) {
        Cart shoppingCart = cartRepository.findByTitle(cartTitle);
        List<CartCommodity>  cartCommodities = shoppingCart.getCartCommodities();
        List<CartCommodity>  findCommodity = cartCommodities.stream().filter( commdityItem -> commdityItem.getCommodity().getCommditiyTitle().equalsIgnoreCase(commoitytitle) ).toList();
        if(findCommodity.size() > 0 ){
            CartCommodity cartCommodity = findCommodity.get(0);
            Long currentOrderNumber = cartCommodity.getNumberOfCommodityOrdered();
            Long newOrderNumber = currentOrderNumber + numberOfCommodity;
            cartCommodity.setNumberOfCommodityOrdered(newOrderNumber);
            saveAndFlush(cartCommodity);
            return  cartCommodity;

        }
        Commodity commodity = commodityRepository.findByCommditiyTitle(commoitytitle);
        CartCommodity cartCommodityNew = new CartCommodity(commodity,shoppingCart,numberOfCommodity );
        saveAndFlush(cartCommodityNew);
         return cartCommodityNew;
    }



    public <S extends CartCommodity> S saveAndFlush(S entity) {
        return cartCommodityRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends CartCommodity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CartCommodity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CartCommodity getOne(Long aLong) {
        return null;
    }

    @Override
    public CartCommodity getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CartCommodity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CartCommodity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CartCommodity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CartCommodity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CartCommodity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CartCommodity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CartCommodity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
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
    public List<CartCommodity> findAll() {
        return null;
    }

    @Override
    public List<CartCommodity> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<CartCommodity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public Page<CartCommodity> findAll(Pageable pageable) {
        return null;
    }



    @Override
    public <S extends CartCommodity> S save(S entity) {
        return cartCommodityRepository.save(entity);
    }

    @Override
    public <S extends CartCommodity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

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
