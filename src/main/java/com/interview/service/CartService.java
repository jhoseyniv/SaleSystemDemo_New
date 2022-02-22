package com.interview.service;

import com.interview.beans.cart.CartCommodityBean;
import com.interview.beans.cart.CartDisountBean;
import com.interview.beans.cart.ShoppingCartBean;
import com.interview.beans.discount.CartCommodityDiscountItemBean;
import com.interview.beans.discount.CartDiscountSheetBean;
import com.interview.entity.Cart;
import com.interview.entity.CartCommodity;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;
import com.interview.repository.CartCommodityRepository;
import com.interview.repository.CartRepository;
import com.interview.repository.CommodityDiscountStrategyRepository;
import com.interview.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public  class CartService implements CartRepository {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private CommodityDiscountStrategyRepository  commodityDiscountStrategyRepository;

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
        CartDiscountSheetBean discountSheet = new CartDiscountSheetBean();
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

    public CartDiscountSheetBean getCartDiscountSheetFromCart(Cart cart) {
        CartDiscountSheetBean cartDiscountSheet = new CartDiscountSheetBean();
        List<CartCommodityDiscountItemBean>  cartCommodityDiscountItems = new ArrayList<CartCommodityDiscountItemBean>();
        cartDiscountSheet.setTitle(cart.getTitle());
        cartDiscountSheet.setCreatedDate(cart.getCreatedDate());
        cartCommodityDiscountItems = getCartCommdotiyDicsountItemsFromCart(cart);
        cartDiscountSheet.setCartCommodityDiscountItems(cartCommodityDiscountItems);
        return cartDiscountSheet;
    }


     public List<CartCommodityDiscountItemBean>  getCartCommdotiyDicsountItemsFromCart(Cart cart) {
         List<CartCommodityDiscountItemBean>  cartCommodityDiscountItems = new ArrayList<CartCommodityDiscountItemBean>();
         List<CartCommodity>  cartCommodities =  cart.getCartCommodities();

         for(int i=0 ; i<cartCommodities.size(); i++ ) {
             CartCommodity cartCommodity = cartCommodities.get(i);
             Long id = cartCommodity.getCommodity().getId();
             Optional<Commodity> commodity = commodityRepository.findById(id);
             if (commodity.isPresent()){
                 CartCommodityDiscountItemBean cartCommodityDiscountItem = CartCommodityDiscountItemBean.getInstanceFromEntity(cartCommodity, commodity.get().getCommodityDiscountStrategies());
                 cartCommodityDiscountItems.add(cartCommodityDiscountItem);
             }
         }
          return  cartCommodityDiscountItems;
     }

    public  List<CartDisountBean> getCartDiscounts(CartDiscountSheetBean discountSheet) {
        List<CartDisountBean> cartDisountBeanList = new ArrayList<CartDisountBean>();
         List<CartCommodityDiscountItemBean> cartCommodityDiscountItems = discountSheet.getCartCommodityDiscountItems();
        List<CartCommodityDiscountItemBean> commodityItemsMeetStrategies = cartCommodityDiscountItems.stream().
                        filter(commdityItem -> commdityItem.getMinNumberOfCommdityMeetDiscount() >= commdityItem.getNumberOfCommodityOrdered()).toList();
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
