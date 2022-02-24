package com.interview.service;

import com.interview.beans.cart.GiftStrategyDiscountBean;
import com.interview.entity.Cart;
import com.interview.entity.CartCommodity;
import com.interview.entity.Commodity;
import com.interview.entity.StrategyTypes;
import com.interview.repository.CartCommodityRepository;
import com.interview.repository.CartRepository;
import com.interview.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
            return  cartCommodityRepository.save(cartCommodity);

        }
        Commodity commodity = commodityRepository.findByCommditiyTitle(commoitytitle);
        CartCommodity cartCommodityNew = new CartCommodity(commodity,shoppingCart,numberOfCommodity );

         return cartCommodityRepository.save(cartCommodityNew);
    }

    @Override
    public <S extends CartCommodity> S save(S entity) {
        return cartCommodityRepository.save(entity);
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
