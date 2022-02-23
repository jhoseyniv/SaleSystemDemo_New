package com.interview.beans.cart;

public class PercentStrategyDiscountBean extends  CartDisountBean {
    private Long  discountPercent;
    private double  totalPriceAfterDiscount;

    public Long getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Long discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(double totalPriceAfterDiscount) {
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public PercentStrategyDiscountBean(Long commodityId,String commditiyTitle, double originalPrice, String priceCurrency, double numberOfCommodityOrdered, double totalPriceWithoutDiscount, String strategyTitle, Long minNumberOfCommdityMeetDiscount, Long discountPercent, double totalPriceAfterDiscount) {
        super(commodityId,commditiyTitle, originalPrice, priceCurrency, numberOfCommodityOrdered, totalPriceWithoutDiscount, strategyTitle, minNumberOfCommdityMeetDiscount);
        this.discountPercent = discountPercent;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }
}
