package com.interview.beans.commodity;

import org.springframework.stereotype.Component;

@Component
public class DiscountStrategyBean {
    private String strategyTitle;
    private String strategyMessage;
    private double newPrice;
    private String priceCurrency;

    public DiscountStrategyBean() {
    }

    public DiscountStrategyBean(String strategyTitle, String strategyMessage, double newPrice,String priceCurrency) {
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
