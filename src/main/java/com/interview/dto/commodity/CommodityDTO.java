package com.interview.dto.commodity;


import java.util.List;

public class CommodityDTO {

    private Long id;
    private String commditiyTitle;
    private List<DiscountStrategyDTO> strategydicuontMeeted;

    private double originalPrice;


    private String priceCurrency;

    public String getCommditiyTitle() {
        return commditiyTitle;
    }

    public void setCommditiyTitle(String commditiyTitle) {
        this.commditiyTitle = commditiyTitle;
    }

    public List<DiscountStrategyDTO> getStrategydicuontMeeted() {
        return strategydicuontMeeted;
    }

    public void setStrategydicuontMeeted(List<DiscountStrategyDTO> strategydicuontMeeted) {
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

    public CommodityDTO() {
    }

    public CommodityDTO(Long id, String commditiyTitle, double originalPrice , String priceCurrency, List<DiscountStrategyDTO> strategies) {
        this.id =id;
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.strategydicuontMeeted = strategies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
