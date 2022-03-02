package com.interview.dto.cart;



public class CartDisountDTO {
    private String strategyTitle;
    private Long  minNumberOfCommdityMeetDiscount;

    public CartDisountDTO() {
    }

    public CartDisountDTO(String strategyTitle, Long minNumberOfCommdityMeetDiscount) {
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
