package com.interview.beans.cart;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public class ShoppingCartBean {
    private String title;
    private String description;
    private ZonedDateTime createdDate;
    private List<CartCommodityBean> cartCommodityBeanList;
    private List<GiftStrategyDiscountBean> giftStrategyDiscountBeanList;
    private List<PercentStrategyDiscountBean> percentStrategyDiscountBeanList;

    private String status;

    public List<CartCommodityBean> getCartCommodityBeanList() {
        return cartCommodityBeanList;
    }

    public void setCartCommodityBeanList(List<CartCommodityBean> cartCommodityBeanList) {
        this.cartCommodityBeanList = cartCommodityBeanList;
    }

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

    public ShoppingCartBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GiftStrategyDiscountBean> getGiftStrategyDiscountBeanList() {
        return giftStrategyDiscountBeanList;
    }

    public void setGiftStrategyDiscountBeanList(List<GiftStrategyDiscountBean> giftStrategyDiscountBeanList) {
        this.giftStrategyDiscountBeanList = giftStrategyDiscountBeanList;
    }

    public List<PercentStrategyDiscountBean> getPercentStrategyDiscountBeanList() {
        return percentStrategyDiscountBeanList;
    }

    public void setPercentStrategyDiscountBeanList(List<PercentStrategyDiscountBean> percentStrategyDiscountBeanList) {
        this.percentStrategyDiscountBeanList = percentStrategyDiscountBeanList;
    }

    public ShoppingCartBean(String title, String description, ZonedDateTime createdDate, List<CartCommodityBean> cartCommodityBeanList, List<GiftStrategyDiscountBean> giftStrategyDiscountBeanList, List<PercentStrategyDiscountBean> percentStrategyDiscountBeanList, String status) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.cartCommodityBeanList = cartCommodityBeanList;
        this.giftStrategyDiscountBeanList = giftStrategyDiscountBeanList;
        this.percentStrategyDiscountBeanList = percentStrategyDiscountBeanList;
        this.status = status;
    }

}
