package com.interview.dto.cart;

public class PercentStrategyDiscountDTO extends CartDisountDTO {
    private Long commditiyId;
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private double numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private double totalPriceAfterDiscount ;
    private Long dicountPercent ;

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

    public double getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(double totalPriceAfterDiscount) {
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public Long getDicountPercent() {
        return dicountPercent;
    }

    public void setDicountPercent(Long dicountPercent) {
        this.dicountPercent = dicountPercent;
    }

    public PercentStrategyDiscountDTO(Long commditiyId, String strategyTitle, Long minNumberOfCommdityMeetDiscount, Long dicountPercent , String commditiyTitle, double originalPrice,
                                      String priceCurrency, double numberOfCommodityOrdered, double totalPriceWithoutDiscount, double totalPriceAfterDiscount) {
        super(strategyTitle, minNumberOfCommdityMeetDiscount);
        this.commditiyId = commditiyId;
        this.commditiyTitle = commditiyTitle;
        this.dicountPercent = dicountPercent;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }
}
