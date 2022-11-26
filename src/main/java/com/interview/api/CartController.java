package com.interview.api;

import com.interview.dto.cart.GiftStrategyDiscountDTO;
import com.interview.dto.cart.PercentStrategyDiscountDTO;
import com.interview.dto.cart.ShoppingCartDTO;
import com.interview.dto.discount.CartDiscountSheetDTO;
import com.interview.customexception.NegativePriceException;
import com.interview.entity.Cart;
import com.interview.service.CartCommodityService;
import com.interview.service.CartService;
import com.interview.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carts")

public class CartController {

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
    public ShoppingCartDTO getShoppingCartBean(@PathVariable String title) throws NegativePriceException {
        ShoppingCartDTO shoppingCartBean = new ShoppingCartDTO();
        Cart cart = cartService.findByTitle(title);
        shoppingCartBean = cartService.getShoppingCartWithDsicounts(cart);
        return shoppingCartBean;
    }

    @RequestMapping(value = "/sheet/{title}", method = RequestMethod.GET)
    @ResponseBody
    public CartDiscountSheetDTO getCartDiscountSheettBean(@PathVariable String title) {
        CartDiscountSheetDTO cartDiscountSheetBean = new CartDiscountSheetDTO();
        Cart cart = cartService.findByTitle(title);
        cartDiscountSheetBean = cartService.getCartDiscountSheetFromCart(cart);
        return cartDiscountSheetBean;
    }

    @RequestMapping(value = "/discounts/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<PercentStrategyDiscountDTO> getCartDiscountItems(@PathVariable String title) throws NegativePriceException {
        Cart cart = cartService.findByTitle(title);
        CartDiscountSheetDTO discountSheet = new CartDiscountSheetDTO();
        discountSheet = cartService.getCartDiscountSheetFromCart(cart);
        List<PercentStrategyDiscountDTO> discountPercentItems =cartService.getCartPercentDiscounts(discountSheet);
        return discountPercentItems;
    }

    @RequestMapping(value = "/gifts/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<GiftStrategyDiscountDTO> getCartGiftItems(@PathVariable String title) throws NegativePriceException {
        Cart cart = cartService.findByTitle(title);
        CartDiscountSheetDTO discountSheet = new CartDiscountSheetDTO();
        discountSheet = cartService.getCartDiscountSheetFromCart(cart);
        List<GiftStrategyDiscountDTO> giftItems =cartService.getCartGiftDiscounts(discountSheet);
        return giftItems;
    }

    @Transactional
    @RequestMapping(value = "/add/{numberOfCommodity}/{commodityTitle}/to/{cartTitle}", method = { RequestMethod.GET, RequestMethod.POST })
    public ShoppingCartDTO addCommodityToOrder(@PathVariable Long numberOfCommodity , @PathVariable String commodityTitle, @PathVariable String cartTitle)  {
        cartCommodityService.saveorUpdate(cartTitle,commodityTitle,numberOfCommodity);
        Cart updateShoppingCart = cartService.findByTitle(cartTitle);
        ShoppingCartDTO shoppingCartBean = cartService.getShoppingCartWithDsicounts(updateShoppingCart);
        return shoppingCartBean;
    }

}