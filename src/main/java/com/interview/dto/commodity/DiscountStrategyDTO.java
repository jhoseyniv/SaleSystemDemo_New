package com.interview.dto.commodity;


public class DiscountStrategyDTO {
    private String strategyTitle;
    private String strategyMessage;
    private double newPrice;
    private String priceCurrency;

    public DiscountStrategyDTO() {
    }

    public DiscountStrategyDTO(String strategyTitle, String strategyMessage, double newPrice, String priceCurrency) {
        this.strategyTitle = strategyTitle;
        this.strategyMessage = strategyMessage;
        this.newPrice = newPrice;
        this.priceCurrency = priceCurrency;
    }



    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyMessage() {
        return strategyMessage;
    }

    public void setStrategyMessage(String strategyMessage) {
        this.strategyMessage = strategyMessage;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }


}
