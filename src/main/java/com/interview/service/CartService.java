package com.interview.service;

import com.interview.beans.cart.CartCommodityBean;
import com.interview.beans.cart.CartDisountBean;
import com.interview.beans.cart.ShoppingCartBean;
import com.interview.beans.discount.CartDiscountSheet;
import com.interview.entity.Cart;
import com.interview.entity.CartCommodity;
import com.interview.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class CartService implements CartRepository {
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Collection<Cart> findByCreatedDate(ZonedDateTime createdDate) {
        return cartRepository.findByCreatedDate(createdDate);
    }

    @Override
    public Collection<Cart> findByDescription(String description) {
        return cartRepository.findByDescription(description);
    }

    @Override
    public Collection<Cart> findByDescriptionContaining(String serachTerm) {
        return cartRepository.findByDescriptionContaining(serachTerm);
    }

    @Override
    public <S extends Cart> S save(S s) {
       return cartRepository.save(s);
    }

    @Override
    public <S extends Cart> Iterable<S> saveAll(Iterable<S> iterable) {

        return null;
    }

    @Override
    public Optional<Cart> findById(Long aLong) {
        return Optional.empty();
    }


    public ShoppingCartBean getShoppingCartWithDsicounts(Cart cart) {
        List<CartCommodityBean> cartCommodityBeanList = getCartCommodities(cart);
        CartDiscountSheet discountSheet = new CartDiscountSheet();
        discountSheet = getCartDiscountSheetFromCart(cart);
        List<CartDisountBean>  cartDisountBeanList = getCartDiscounts(discountSheet);

        ShoppingCartBean shoppingCartBean= new ShoppingCartBean(cart.getTitle(),cart.getDescription(),
                cart.getCreatedDate(),cart.getStatus().getTitle(),cartCommodityBeanList,cartDisountBeanList);
     return shoppingCartBean;
    }



    public  List<CartCommodityBean> getCartCommodities(Cart cart) {
        List<CartCommodityBean> cartCommodityBeanList = new ArrayList<CartCommodityBean>();
        List<CartCommodity> cartCommodities = cart.getCartCommodities();
        for(CartCommodity cartCommodity : cartCommodities ){
            CartCommodityBean cartCommodityBean = CartCommodityBean.getInstanceFromEntity(cartCommodity);
            cartCommodityBeanList.add(cartCommodityBean);
        }
        return cartCommodityBeanList;
    }

    public  CartDiscountSheet getCartDiscountSheetFromCart(Cart cart) {
        CartDiscountSheet  cartDiscountSheet = new CartDiscountSheet();

        return cartDiscountSheet;
    }

    public  List<CartDisountBean> getCartDiscounts(CartDiscountSheet discountSheet) {
        List<CartDisountBean> cartDisountBeanList = new ArrayList<CartDisountBean>();
        return cartDisountBeanList;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Collection<Cart> findAll() {

        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findByTitle(String title) {
        return cartRepository.findByTitle(title);
    }

    @Override
    public Iterable<Cart> findAllById(Iterable<Long> iterable) {

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
    public void delete(Cart order) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cart> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
