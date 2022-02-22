package com.interview.api;

import com.interview.beans.cart.ShoppingCartBean;
import com.interview.beans.discount.CartDiscountSheetBean;
import com.interview.entity.Cart;
import com.interview.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/carts")

public class ShoppingCarController {

    @Autowired
    private CartService cartService;


    @GetMapping("/")
    public @ResponseBody Iterable<Cart> getCarts() {
         Iterable<Cart> carts = cartService.findAll();
        return carts;
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    @ResponseBody
    public ShoppingCartBean getShoppingCartBean(@PathVariable String title) {
        ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
        Optional<Cart> cart = cartService.findByTitle(title);
        shoppingCartBean = cartService.getShoppingCartWithDsicounts(cart.get());
        return shoppingCartBean;
    }

    @RequestMapping(value = "/sheet/{title}", method = RequestMethod.GET)
    @ResponseBody
    public CartDiscountSheetBean getCartDiscountSheettBean(@PathVariable String title) {
        CartDiscountSheetBean cartDiscountSheetBean = new CartDiscountSheetBean();
        if(Objects.isNull(cartService)) {
            System.out.println("------------cartService-------------------null");

        }
        Optional<Cart> cart = cartService.findByTitle(title);
        cartDiscountSheetBean = cartService.getCartDiscountSheetFromCart(cart.get());
        return cartDiscountSheetBean;
    }

    @RequestMapping(value = "/find/title/{title}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Cart> getCartByTitle(@PathVariable String title) {
        ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
        Optional<Cart> cart = cartService.findByTitle(title);

        return cart;
    }

    @RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Cart> getSaleOrderById(@PathVariable Long id) {
        if(Objects.isNull(cartService)){
            System.out.println("-------------------------------null");
        }
        Optional<Cart> saleOrder = cartService.findById(id);
        return saleOrder;
    }


//    @Transactional
//    @RequestMapping(value = "/add/{orderId}/{commodityId}/{numberOfCommodity}", method = { RequestMethod.GET, RequestMethod.POST })
//    public Cart addCommodityToOrder(@PathVariable Long orderId , @PathVariable Long commodityId, @PathVariable Long numberOfCommodity)  {
//        Cart order = shopingCartService.findSaleOrderById(orderId);
//        Optional<Commodity> commodity = commodityService.findById(commodityId);
//        CartCommodity cartCommodity = new CartCommodity(commodity.get(),order,numberOfCommodity);
//        cartCommodityService.save(cartCommodity);
//        Cart updatedOrder = cartService.findSaleOrderById(orderId);
//        return updatedOrder;
//    }

}