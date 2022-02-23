package com.interview.beans.cart;


import org.springframework.stereotype.Component;

@Component
public class CartDisountBean {
    private String strategyTitle;
    private Long  minNumberOfCommdityMeetDiscount;

    public CartDisountBean() {
    }

    public CartDisountBean(String strategyTitle, Long minNumberOfCommdityMeetDiscount) {
        this.strategyTitle = strategyTitle;
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
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
