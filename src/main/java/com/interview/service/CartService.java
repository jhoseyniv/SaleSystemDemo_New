package com.interview.service;

import com.interview.beans.cart.CartCommodityBean;
import com.interview.beans.cart.ShoppingCartBean;
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

    public  List<CartCommodityBean> getCartCommodities(Cart cart) {
        List<CartCommodityBean> cartCommodityBeanList = new ArrayList<CartCommodityBean>();
        List<CartCommodity> cartCommodities = cart.getCartCommodities();
        for(CartCommodity cartCommodity : cartCommodities ){
            System.out.println("------->"+ cartCommodity.getNumberOfCommodityOrdered());
            CartCommodityBean cartCommodityBean = CartCommodityBean.getInstanceFromEntity(cartCommodity);
            cartCommodityBeanList.add(cartCommodityBean);
        }

      return cartCommodityBeanList;
    }

    public ShoppingCartBean getShoppingCartWithDsicounts(Cart cart) {
        List<CartCommodityBean> cartCommodityBeanList = getCartCommodities(cart);
        ShoppingCartBean shoppingCartBean= new ShoppingCartBean(cart.getTitle(),cart.getDescription(),cart.getCreatedDate(),cart.getStatus().getTitle(),cartCommodityBeanList);
//        List<CartCommodity> shoppingItems = cart.getCartCommodities();
//        String  commodityName="hat";
//        Optional<CartCommodity> commodity= shoppingItems.stream()
//                .filter(x -> commodityName.equals(x.getCommodity().getCommditiyTitle()))
//                .findAny();
//        System.out.println("Commodity----->"+commodity.get().getNumberOfCommodityOrdered());

     return shoppingCartBean;
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
