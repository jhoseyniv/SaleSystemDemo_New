package com.interview.beans.discount;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public class CartDiscountSheetBean {
    private String title;
    private String description;
    private ZonedDateTime createdDate;
    private List<CartCommodityDiscountItemBean>  cartCommodityDiscountItems;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<CartCommodityDiscountItemBean> getCartCommodityDiscountItems() {
        return cartCommodityDiscountItems;
    }

    public void setCartCommodityDiscountItems(List<CartCommodityDiscountItemBean> cartCommodityDiscountItems) {
        this.cartCommodityDiscountItems = cartCommodityDiscountItems;
    }

    public CartDiscountSheetBean() {
    }

    public CartDiscountSheetBean(String title, String description, ZonedDateTime createdDate, List<CartCommodityDiscountItemBean> cartCommodityDiscountItems) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.cartCommodityDiscountItems = cartCommodityDiscountItems;
    }
}
