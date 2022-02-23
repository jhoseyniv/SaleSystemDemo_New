
package com.interview.beans.cart;


import java.util.List;

public class GiftStrategyDiscountBean  extends  CartDisountBean{
    private Long    commoditytHaveToGiftId;
    private String  mameOfCommoditytHaveToGift;
    private List<String>  relatedCommodity;

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

    public List<String> getRelatedCommodity() {
        return relatedCommodity;
    }

    public void setRelatedCommodity(List<String> relatedCommodity) {
        this.relatedCommodity = relatedCommodity;
    }

    public GiftStrategyDiscountBean() {
    }

    public GiftStrategyDiscountBean(String strategyTitle, Long minNumberOfCommdityMeetDiscount, Long commoditytHaveToGiftId, String mameOfCommoditytHaveToGift, List<String> relatedCommodity) {
        super(strategyTitle, minNumberOfCommdityMeetDiscount);
        this.commoditytHaveToGiftId = commoditytHaveToGiftId;
        this.mameOfCommoditytHaveToGift = mameOfCommoditytHaveToGift;
        this.relatedCommodity = relatedCommodity;
    }
}
