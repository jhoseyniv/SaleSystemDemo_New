package com.interview.api;

import com.interview.entity.Cart;
import com.interview.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/cart")

public class ShoppingCarController {

    @Autowired
    private CartService cartService;


    @GetMapping("/list")
    public @ResponseBody Iterable<Cart> getSalesOrders() {
        if(Objects.isNull(cartService)){
            System.out.println("----------------------null");
        }
        Iterable<Cart> saleOrders = cartService.findAll();
        return saleOrders;
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

//    @GetMapping( "/find/description/{description}")
//    public Collection<ShopingCart> getSaleOrderByDescription(@PathVariable String description) {
//        Collection<ShopingCart> saleOrders = shopingCartService.findByDescription(description);
//        return saleOrders;
//    }
//
//    @GetMapping( "/find/intext/{intext}")
//    public Collection<ShopingCart> getSalesOrderContainByDescription(@PathVariable String intext) {
//        Collection<ShopingCart> saleOrders = shopingCartService.findByDescriptionContaining(intext);
//        return saleOrders;
//    }

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