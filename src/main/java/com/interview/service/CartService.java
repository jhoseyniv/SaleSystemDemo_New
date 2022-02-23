package com.interview.service;

import com.interview.beans.cart.*;
import com.interview.beans.discount.CartCommodityDiscountItemBean;
import com.interview.beans.discount.CartDiscountSheetBean;
import com.interview.customexception.NegativePriceException;
import com.interview.entity.*;
import com.interview.repository.CartRepository;
import com.interview.repository.CommodityRepository;
import com.interview.repository.DiscountStrategyRepository;
import com.interview.util.DiscountUtitlty;
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
    private DiscountStrategyRepository discountStrategyRepository;

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


    public ShoppingCartBean getShoppingCartWithDsicounts(Cart cart) throws NegativePriceException {

        List<CartCommodityBean> cartCommodityBeanList = getCartCommodities(cart);

        CartDiscountSheetBean discountSheet = new CartDiscountSheetBean();

        discountSheet = getCartDiscountSheetFromCart(cart);
        List<GiftStrategyDiscountBean>  giftStrategyDiscountBean = getCartGiftDiscounts(discountSheet);
        List<PercentStrategyDiscountBean>  percentStrategyDiscountBean = getCartPercentDiscounts(discountSheet);
        ShoppingCartBean shoppingCartBean= new ShoppingCartBean(cart.getTitle(),cart.getDescription(),
                cart.getCreatedDate(),cartCommodityBeanList,giftStrategyDiscountBean,percentStrategyDiscountBean,cart.getStatus().getTitle());

     return shoppingCartBean;
    }

/*
    public  List<CommodityBean> getCommoditiesWithGiftStrategy(Cart cart) {
        List<CommodityBean> commodtitesBeanList = new ArrayList<CommodityBean>();
        List<CartCommodity> cartCommoditites = new ArrayList<CartCommodity>();
        cartCommoditites = cart.getCartCommodities();

        for(CartCommodity cartCommodity: cartCommoditites){
            String commodityTitle = cartCommodity.getCommodity().getCommditiyTitle();
            String priceCurrency = cartCommodity.getCommodity().getPriceCurrency();
            double originalPrice = cartCommodity.getCommodity().getPrice();
            List<CommodityDiscountStrategy> strategies = cartCommodity.getCommodity().getCommodityDiscountStrategies();
        }

        cartCommoditites.get(0).getCommodity().getCommodityDiscountStrategies();

      return  commodtitesBeanList;
    }
*/
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

    public  List<GiftStrategyDiscountBean> getCartGiftDiscounts(CartDiscountSheetBean discountSheet) {
        List<CartCommodityDiscountItemBean> cartCommodityDiscountItems = discountSheet.getCartCommodityDiscountItems();
        GiftStrategyDiscountBean cartItemsGiftStrategyBatch = new GiftStrategyDiscountBean();
        List<GiftStrategyDiscountBean> cartItemsGiftStrategy = new ArrayList<GiftStrategyDiscountBean>();
        boolean isGiftStrategy = false;
        List<CartCommodityDiscountItemBean> tempList = cartCommodityDiscountItems.stream().
                filter( commdityItem -> commdityItem.getStrategyType().equalsIgnoreCase(StrategyTypes.GIFT.toString()) ).toList();

        Map<String, List<CartCommodityDiscountItemBean> > commodityItemsMeetGiftStrategy = tempList.stream().collect(
                Collectors.groupingBy(CartCommodityDiscountItemBean::getStrategyTitle, Collectors.toList()));

        Iterator<Map.Entry<String, List<CartCommodityDiscountItemBean>> > i = commodityItemsMeetGiftStrategy.entrySet().iterator();
        commodityItemsMeetGiftStrategy.keySet().stream().forEach(el-> System.out.println(el));

        while (i.hasNext()) {
            Map.Entry<String, List<CartCommodityDiscountItemBean>> item = i.next();
            String key = item.getKey();
            List<CartCommodityDiscountItemBean> batchItem = item.getValue();

           isGiftStrategy = checkBtachItem(key,batchItem);
           if( isGiftStrategy )  {
                        cartItemsGiftStrategyBatch = DiscountUtitlty.getGiftStrategyBean(batchItem);
                        cartItemsGiftStrategy.add(cartItemsGiftStrategyBatch);
           }
        }
        return cartItemsGiftStrategy;
    }

     public boolean  checkBtachItem(String bachName, List<CartCommodityDiscountItemBean> batchItem) {
        boolean find=false;
        for( int i=0; i<batchItem.size();i++){
            CartCommodityDiscountItemBean item = new CartCommodityDiscountItemBean();
            item = batchItem.get(i);
            DiscountStrategy discountStrategy = discountStrategyRepository.findByStrategyTitle(bachName);
            List<CommodityDiscountStrategy> commodityDiscountStrategy = discountStrategy.getCommodity_discountStrategies();
             int lenght = commodityDiscountStrategy.size();
             int j=0;
            while ( j<lenght){
                Commodity commodity = commodityDiscountStrategy.get(j).getCommodity();
                if(item.getCommditiyTitle().equalsIgnoreCase(commodity.getCommditiyTitle())) {
                    find = true;
                    j = lenght;
                } else {
                    find = false;
                }
                j++;

            }

        }
         return  find;
     }
    public  List<PercentStrategyDiscountBean> getCartPercentDiscounts(CartDiscountSheetBean discountSheet) throws NegativePriceException {
        List<CartCommodityDiscountItemBean> cartCommodityDiscountItems = discountSheet.getCartCommodityDiscountItems();

        List<CartCommodityDiscountItemBean> commodityItemsMeetDiscountStrategy = cartCommodityDiscountItems.stream().
                filter( commdityItem -> commdityItem.getStrategyType().equalsIgnoreCase(StrategyTypes.DISCOUNT.toString()) ).
                filter( commdityItem -> commdityItem.getMinNumberOfCommdityMeetDiscount() <= commdityItem.getNumberOfCommodityOrdered()).toList();

       List<PercentStrategyDiscountBean> cartItemsDiscountStrategy = DiscountUtitlty.calculatePercentDiscountStrategy(commodityItemsMeetDiscountStrategy);
       return cartItemsDiscountStrategy;
    }


    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Collection<Cart> findAll() {

        return cartRepository.findAll();
    }

    public Cart findByTitle(String title) {
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
