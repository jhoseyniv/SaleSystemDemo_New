package com.interview.api;

import com.interview.entity.Commodity;
import com.interview.entity.ShopingCartCommodity;
import com.interview.entity.ShopingCart;
import com.interview.repository.ShopingCartRepository;
import com.interview.service.CommodityService;
import com.interview.service.ShopingCartCommodityService;
import com.interview.service.ShopingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/cart")
public class SaleOrderAPI {

    @Autowired
    private ShopingCartService shopingCartService;

    @Autowired
    private ShopingCartCommodityService cartCommodityService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/list")
    public Collection<ShopingCart> getSalesOrders(Model model) {
        Collection<ShopingCart> saleOrders = shopingCartService.findAll();
        return saleOrders;
    }


    @RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<ShopingCart> getSaleOrderById(@PathVariable Long id) {
        Optional<ShopingCart> saleOrder = shopingCartService.findById(id);
        return saleOrder;
    }

    @GetMapping( "/find/description/{description}")
    public Collection<ShopingCart> getSaleOrderByDescription(@PathVariable String description) {
        Collection<ShopingCart> saleOrders = shopingCartService.findByDescription(description);
        return saleOrders;
    }

    @GetMapping( "/find/intext/{intext}")
    public Collection<ShopingCart> getSalesOrderContainByDescription(@PathVariable String intext) {
        Collection<ShopingCart> saleOrders = shopingCartService.findByDescriptionContaining(intext);
        return saleOrders;
    }

    @Transactional
    @RequestMapping(value = "/add/{orderId}/{commodityId}/{numberOfCommodity}", method = { RequestMethod.GET, RequestMethod.POST })
    public ShopingCart addCommodityToOrder(@PathVariable Long orderId , @PathVariable Long commodityId, @PathVariable Long numberOfCommodity)  {
        ShopingCart order = shopingCartService.findSaleOrderById(orderId);
        Optional<Commodity> commodity = commodityService.findById(commodityId);
        ShopingCartCommodity cartCommodity = new ShopingCartCommodity(commodity.get(),order,numberOfCommodity);
        cartCommodityService.save(cartCommodity);
        ShopingCart updatedOrder = shopingCartService.findSaleOrderById(orderId);
        return updatedOrder;
    }

}