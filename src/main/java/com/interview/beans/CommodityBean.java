package com.interview.beans;

import com.interview.diccount.StrategyContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommodityBean {
    private Long id;
    private String commditiyTitle;
    private List<DiscountStrategyBean> strategydicuontMeeted;

    private double originalPrice;


    private String priceCurrency;

    public String getCommditiyTitle() {
        return commditiyTitle;
    }

    public void setCommditiyTitle(String commditiyTitle) {
        this.commditiyTitle = commditiyTitle;
    }

    public List<DiscountStrategyBean> getStrategydicuontMeeted() {
        return strategydicuontMeeted;
    }

    public void setStrategydicuontMeeted(List<DiscountStrategyBean> strategydicuontMeeted) {
        this.strategydicuontMeeted = strategydicuontMeeted;
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

    public CommodityBean() {
    }

    public CommodityBean(String commditiyTitle,double originalPrice ,String priceCurrency, List<DiscountStrategyBean> strategies) {
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.strategydicuontMeeted = strategies;
    }



}
