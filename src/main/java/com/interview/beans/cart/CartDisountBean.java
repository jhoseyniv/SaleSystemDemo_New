package com.interview.beans.cart;


import org.springframework.stereotype.Component;

@Component
public class CartDisountBean {
    private Long commditiyId;
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private double numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private String strategyTitle;
    private Long  minNumberOfCommdityMeetDiscount;

    public CartDisountBean() {
    }

    public CartDisountBean(Long commditiyId,String commditiyTitle, double originalPrice, String priceCurrency, double numberOfCommodityOrdered, double totalPriceWithoutDiscount, String strategyTitle, Long minNumberOfCommdityMeetDiscount) {
        this.commditiyId = commditiyId;
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.strategyTitle = strategyTitle;
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }

    public Long getCommditiyId() {
        return commditiyId;
    }

    public void setCommditiyId(Long commditiyId) {
        this.commditiyId = commditiyId;
    }

    public String getCommditiyTitle() {
        return commditiyTitle;
    }

    public void setCommditiyTitle(String commditiyTitle) {
        this.commditiyTitle = commditiyTitle;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public double getNumberOfCommodityOrdered() {
        return numberOfCommodityOrdered;
    }

    public void setNumberOfCommodityOrdered(double numberOfCommodityOrdered) {
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
    }

    public double getTotalPriceWithoutDiscount() {
        return totalPriceWithoutDiscount;
    }

    public void setTotalPriceWithoutDiscount(double totalPriceWithoutDiscount) {
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
    }
    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public Long getMinNumberOfCommdityMeetDiscount() {
        return minNumberOfCommdityMeetDiscount;
    }

    public void setMinNumberOfCommdityMeetDiscount(Long minNumberOfCommdityMeetDiscount) {
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }
}
