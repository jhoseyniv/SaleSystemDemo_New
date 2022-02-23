
package com.interview.beans.cart;


public class GiftStrategyDiscountBean  extends  CartDisountBean{
    private Long    commoditytHaveToGiftId;
    private String  mameOfCommoditytHaveToGift;


    public Long getCommoditytHaveToGiftId() {
        return commoditytHaveToGiftId;
    }

    public void setCommoditytHaveToGiftId(Long commoditytHaveToGiftId) {
        this.commoditytHaveToGiftId = commoditytHaveToGiftId;
    }

    public String getMameOfCommoditytHaveToGift() {
        return mameOfCommoditytHaveToGift;
    }

    public void setMameOfCommoditytHaveToGift(String mameOfCommoditytHaveToGift) {
        this.mameOfCommoditytHaveToGift = mameOfCommoditytHaveToGift;
    }

    public GiftStrategyDiscountBean(Long commodityId,String commditiyTitle, double originalPrice, String priceCurrency, double numberOfCommodityOrdered, double totalPriceWithoutDiscount, String strategyTitle, Long minNumberOfCommdityMeetDiscount, Long commoditytHaveToGiftId, String mameOfCommoditytHaveToGift) {
        super(commodityId , commditiyTitle, originalPrice, priceCurrency, numberOfCommodityOrdered, totalPriceWithoutDiscount, strategyTitle, minNumberOfCommdityMeetDiscount);
        this.commoditytHaveToGiftId = commoditytHaveToGiftId;
        this.mameOfCommoditytHaveToGift = mameOfCommoditytHaveToGift;
    }
}
