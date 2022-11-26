package com.interview.dto.cart;

import java.time.ZonedDateTime;
import java.util.List;

public class ShoppingCartDTO {
    private String title;
    private String description;
    private ZonedDateTime createdDate;
    private List<OrderedCommodityDTO> orderedCommodityList;
    private List<GiftStrategyDiscountDTO> giftStrategyDiscountBeanList;
    private List<PercentStrategyDiscountDTO> percentStrategyDiscountBeanList;

    private String status;

    public List<OrderedCommodityDTO> getOrderedCommodityList() {
        return orderedCommodityList;
    }

    public void setOrderedCommodityList(List<OrderedCommodityDTO> orderedCommodityList) {
        this.orderedCommodityList = orderedCommodityList;
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

    public ShoppingCartDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GiftStrategyDiscountDTO> getGiftStrategyDiscountBeanList() {
        return giftStrategyDiscountBeanList;
    }

    public void setGiftStrategyDiscountBeanList(List<GiftStrategyDiscountDTO> giftStrategyDiscountBeanList) {
        this.giftStrategyDiscountBeanList = giftStrategyDiscountBeanList;
    }

    public List<PercentStrategyDiscountDTO> getPercentStrategyDiscountBeanList() {
        return percentStrategyDiscountBeanList;
    }

    public void setPercentStrategyDiscountBeanList(List<PercentStrategyDiscountDTO> percentStrategyDiscountBeanList) {
        this.percentStrategyDiscountBeanList = percentStrategyDiscountBeanList;
    }

    public ShoppingCartDTO(String title, String description, ZonedDateTime createdDate, List<OrderedCommodityDTO> orderedCommodityList, List<GiftStrategyDiscountDTO> giftStrategyDiscountBeanList, List<PercentStrategyDiscountDTO> percentStrategyDiscountBeanList, String status) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.orderedCommodityList = orderedCommodityList;
        this.giftStrategyDiscountBeanList = giftStrategyDiscountBeanList;
        this.percentStrategyDiscountBeanList = percentStrategyDiscountBeanList;
        this.status = status;
    }

}
