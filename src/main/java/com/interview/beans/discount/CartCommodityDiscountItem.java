package com.interview.beans.discount;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartCommodityDiscountItem {
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private double numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private List<StrategyDiscountsMeetBean> strategyDiscountsMeetBeans;

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

    public List<StrategyDiscountsMeetBean> getStrategyDiscountsMeetBeans() {
        return strategyDiscountsMeetBeans;
    }

    public void setStrategyDiscountsMeetBeans(List<StrategyDiscountsMeetBean> strategyDiscountsMeetBeans) {
        this.strategyDiscountsMeetBeans = strategyDiscountsMeetBeans;
    }
}
