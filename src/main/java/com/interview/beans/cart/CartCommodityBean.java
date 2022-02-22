package com.interview.beans.cart;

import com.interview.entity.CartCommodity;
import org.springframework.stereotype.Component;

@Component

public class CartCommodityBean {
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private double numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CartCommodityBean() {
    }

    public CartCommodityBean(String commditiyTitle, double originalPrice, String priceCurrency,
                             double numberOfCommodityOrdered, double totalPriceWithoutDiscount, String description) {
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.description = description;
    }
    public static  CartCommodityBean getInstanceFromEntity(CartCommodity cartCommodity){
        String commditiyTitle = cartCommodity.getCommodity().getCommditiyTitle();
        double originalPrice = cartCommodity.getCommodity().getPrice();
        String priceCurrency = cartCommodity.getCommodity().getPriceCurrency();
        long   numberOfCommodityOrdered = cartCommodity.getNumberOfCommodityOrdered();
        double totalPriceWithoutDiscount = originalPrice * numberOfCommodityOrdered;
        return  new CartCommodityBean(commditiyTitle,originalPrice,priceCurrency,numberOfCommodityOrdered,totalPriceWithoutDiscount,"");
    }
}
