package com.interview.api;

import com.interview.beans.cart.GiftStrategyDiscountBean;
import com.interview.beans.cart.PercentStrategyDiscountBean;
import com.interview.beans.cart.ShoppingCartBean;
import com.interview.beans.discount.CartDiscountSheetBean;
import com.interview.customexception.NegativePriceException;
import com.interview.customexception.SalesManagmentException;
import com.interview.entity.Cart;
import com.interview.entity.CartCommodity;
import com.interview.entity.Commodity;
import com.interview.service.CartCommodityService;
import com.interview.service.CartService;
import com.interview.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/carts")

public class ShoppingCarController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CartCommodityService cartCommodityService;

    @GetMapping("/")
    public @ResponseBody Iterable<Cart> getCarts() {
         Iterable<Cart> carts = cartService.findAll();
        return carts;
    }

    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    @ResponseBody
    public ShoppingCartBean getShoppingCartBean(@PathVariable String title) throws NegativePriceException {
        ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
        Cart cart = cartService.findByTitle(title);
        shoppingCartBean = cartService.getShoppingCartWithDsicounts(cart);
        return shoppingCartBean;
    }

    @RequestMapping(value = "/sheet/{title}", method = RequestMethod.GET)
    @ResponseBody
    public CartDiscountSheetBean getCartDiscountSheettBean(@PathVariable String title) {
        CartDiscountSheetBean cartDiscountSheetBean = new CartDiscountSheetBean();
        Cart cart = cartService.findByTitle(title);
        cartDiscountSheetBean = cartService.getCartDiscountSheetFromCart(cart);
        return cartDiscountSheetBean;
    }

    @RequestMapping(value = "/discounts/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<PercentStrategyDiscountBean> getCartDiscountItems(@PathVariable String title) throws NegativePriceException {
        Cart cart = cartService.findByTitle(title);
        CartDiscountSheetBean discountSheet = new CartDiscountSheetBean();
        discountSheet = cartService.getCartDiscountSheetFromCart(cart);
        List<PercentStrategyDiscountBean> discountPercentItems =cartService.getCartPercentDiscounts(discountSheet);
        return discountPercentItems;
    }

    @RequestMapping(value = "/gifts/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<GiftStrategyDiscountBean> getCartGiftItems(@PathVariable String title) throws NegativePriceException {
        Cart cart = cartService.findByTitle(title);
        CartDiscountSheetBean discountSheet = new CartDiscountSheetBean();
        discountSheet = cartService.getCartDiscountSheetFromCart(cart);
        List<GiftStrategyDiscountBean> giftItems =cartService.getCartGiftDiscounts(discountSheet);
        return giftItems;
    }

    @Transactional
    @RequestMapping(value = "/add/{numberOfCommodity}/{commodityTitle}/to/{cartTitle}", method = { RequestMethod.GET, RequestMethod.POST })
    public ShoppingCartBean addCommodityToOrder(@PathVariable Long numberOfCommodity , @PathVariable String commodityTitle, @PathVariable String cartTitle)  {
        cartCommodityService.saveorUpdate(cartTitle,commodityTitle,numberOfCommodity);
        Cart updateShoppingCart = cartService.findByTitle(cartTitle);
        ShoppingCartBean shoppingCartBean = cartService.getShoppingCartWithDsicounts(updateShoppingCart);
        return shoppingCartBean;
    }

}