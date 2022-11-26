package com.interview.service;

import com.interview.dto.cart.*;
import com.interview.dto.discount.CartCommodityDiscountItemDTO;
import com.interview.dto.discount.CartDiscountSheetDTO;
import com.interview.customexception.CartNotFoundException;
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


    public ShoppingCartDTO getShoppingCartWithDsicounts(Cart cart) throws NegativePriceException {
        List<OrderedCommodityDTO> cartCommodityBeanList = getCartCommodities(cart);

        CartDiscountSheetDTO discountSheet = new CartDiscountSheetDTO();

        discountSheet = getCartDiscountSheetFromCart(cart);
        List<GiftStrategyDiscountDTO>  giftStrategyDiscountBean = getCartGiftDiscounts(discountSheet);
        List<PercentStrategyDiscountDTO>  percentStrategyDiscountBean = getCartPercentDiscounts(discountSheet);
        ShoppingCartDTO shoppingCartBean= new ShoppingCartDTO(cart.getTitle(),cart.getDescription(),
                cart.getCreatedDate(),cartCommodityBeanList,giftStrategyDiscountBean,percentStrategyDiscountBean,cart.getStatus().getTitle());

     return shoppingCartBean;
    }

    public  List<OrderedCommodityDTO> getCartCommodities(Cart cart) {
        List<OrderedCommodityDTO> cartCommodityBeanList = new ArrayList<OrderedCommodityDTO>();
        List<CartCommodity> cartCommodities = cart.getCartCommodities();
        for(CartCommodity cartCommodity : cartCommodities ){
            OrderedCommodityDTO cartCommodityBean = OrderedCommodityDTO.getInstanceFromEntity(cartCommodity);
            cartCommodityBeanList.add(cartCommodityBean);
        }
        return cartCommodityBeanList;
    }

    public CartDiscountSheetDTO getCartDiscountSheetFromCart(Cart cart) {
        CartDiscountSheetDTO cartDiscountSheet = new CartDiscountSheetDTO();
        List<CartCommodityDiscountItemDTO>  cartCommodityDiscountItems = new ArrayList<CartCommodityDiscountItemDTO>();
        cartDiscountSheet.setTitle(cart.getTitle());
        cartDiscountSheet.setCreatedDate(cart.getCreatedDate());
        cartCommodityDiscountItems = getCartCommdotiyDicsountItemsFromCart(cart);
        cartDiscountSheet.setCartCommodityDiscountItems(cartCommodityDiscountItems);
        return cartDiscountSheet;
    }


     public List<CartCommodityDiscountItemDTO>  getCartCommdotiyDicsountItemsFromCart(Cart cart) {
         List<CartCommodityDiscountItemDTO>  cartCommodityDiscountItems = new ArrayList<CartCommodityDiscountItemDTO>();
         List<CartCommodity>  cartCommodities =  cart.getCartCommodities();

         for(int i=0 ; i<cartCommodities.size(); i++ ) {
             CartCommodity cartCommodity = cartCommodities.get(i);
             Long id = cartCommodity.getCommodity().getId();
             Optional<Commodity> commodity = commodityRepository.findById(id);
             if (commodity.isPresent()){
                 CartCommodityDiscountItemDTO cartCommodityDiscountItem = CartCommodityDiscountItemDTO.getInstanceFromEntity(cartCommodity, commodity.get().getCommodityDiscountStrategies());
                 cartCommodityDiscountItems.add(cartCommodityDiscountItem);
             }
         }
          return  cartCommodityDiscountItems;
     }

    public  List<GiftStrategyDiscountDTO> getCartGiftDiscounts(CartDiscountSheetDTO discountSheet) {
        List<CartCommodityDiscountItemDTO> cartCommodityDiscountItems = discountSheet.getCartCommodityDiscountItems();
        GiftStrategyDiscountDTO cartItemsGiftStrategyBatch = new GiftStrategyDiscountDTO();
        List<GiftStrategyDiscountDTO> cartItemsGiftStrategy = new ArrayList<GiftStrategyDiscountDTO>();
        boolean isGiftStrategy = false;
        List<CartCommodityDiscountItemDTO> tempList = cartCommodityDiscountItems.stream().
                filter( commdityItem -> commdityItem.getStrategyType().equalsIgnoreCase(StrategyTypes.GIFT.toString()) ).toList();

        Map<String, List<CartCommodityDiscountItemDTO> > commodityItemsMeetGiftStrategy = tempList.stream().collect(
                Collectors.groupingBy(CartCommodityDiscountItemDTO::getStrategyTitle, Collectors.toList()));

        Iterator<Map.Entry<String, List<CartCommodityDiscountItemDTO>> > i = commodityItemsMeetGiftStrategy.entrySet().iterator();
        commodityItemsMeetGiftStrategy.keySet().stream().forEach(el-> System.out.println(el));

        while (i.hasNext()) {
            Map.Entry<String, List<CartCommodityDiscountItemDTO>> item = i.next();
            String key = item.getKey();
            List<CartCommodityDiscountItemDTO> batchItem = item.getValue();

           isGiftStrategy = checkBtachItem(key,batchItem);
           if( isGiftStrategy )  {
                        cartItemsGiftStrategyBatch = DiscountUtitlty.getGiftStrategyBean(batchItem);
                        cartItemsGiftStrategy.add(cartItemsGiftStrategyBatch);
           }
        }
        return cartItemsGiftStrategy;
    }

     public boolean  checkBtachItem(String bachName, List<CartCommodityDiscountItemDTO> batchItem) {
        boolean find=false;
        for( int i=0; i<batchItem.size();i++){
            CartCommodityDiscountItemDTO item = new CartCommodityDiscountItemDTO();
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
    public  List<PercentStrategyDiscountDTO> getCartPercentDiscounts(CartDiscountSheetDTO discountSheet) throws NegativePriceException {
        List<CartCommodityDiscountItemDTO> cartCommodityDiscountItems = discountSheet.getCartCommodityDiscountItems();

        List<CartCommodityDiscountItemDTO> commodityItemsMeetDiscountStrategy = cartCommodityDiscountItems.stream().
                filter( commdityItem -> commdityItem.getStrategyType().equalsIgnoreCase(StrategyTypes.DISCOUNT.toString()) ).
                filter( commdityItem -> commdityItem.getMinNumberOfCommdityMeetDiscount() <= commdityItem.getNumberOfCommodityOrdered()).toList();

       List<PercentStrategyDiscountDTO> cartItemsDiscountStrategy = DiscountUtitlty.calculatePercentDiscountStrategy(commodityItemsMeetDiscountStrategy);
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
        Cart  cart = cartRepository.findByTitle(title);
        if(Objects.isNull(cart)) throw new CartNotFoundException(title,"Cart Not Found");
        return cart;
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
