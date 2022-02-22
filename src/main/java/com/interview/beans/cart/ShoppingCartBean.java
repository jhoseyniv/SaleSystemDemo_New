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
    private List<CartDisountBean> cartDisountBeanList;

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

    public List<CartDisountBean> getCartDisountBeanList() {
        return cartDisountBeanList;
    }

    public void setCartDisountBeanList(List<CartDisountBean> cartDisountBeanList) {
        this.cartDisountBeanList = cartDisountBeanList;
    }

    public ShoppingCartBean(String title, String description, ZonedDateTime createdDate, String status, List<CartCommodityBean> cartCommodityBeanList,List<CartDisountBean> cartDisountBeanList ) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
        this.cartCommodityBeanList = cartCommodityBeanList;
        this.cartDisountBeanList = cartDisountBeanList;
    }

}
