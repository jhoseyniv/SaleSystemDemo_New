package com.interview.beans.discount;

import com.interview.entity.CartCommodity;
import com.interview.entity.CommodityDiscountStrategy;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class CartCommodityDiscountItemBean {
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private double numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private String strategyTitle;
    private String strategyType;
    private Long   strategyAchivement;

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

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public Long getStrategyAchivement() {
        return strategyAchivement;
    }

    public void setStrategyAchivement(Long strategyAchivement) {
        this.strategyAchivement = strategyAchivement;
    }

    public CartCommodityDiscountItemBean() {
    }

    public CartCommodityDiscountItemBean(String commditiyTitle, double originalPrice, String priceCurrency,
                                         double numberOfCommodityOrdered, double totalPriceWithoutDiscount,
                                         String strategyTitle, String strategyType, Long strategyAchivement) {
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.strategyTitle = strategyTitle;
        this.strategyType = strategyType;
        this.strategyAchivement = strategyAchivement;
    }
    public static CartCommodityDiscountItemBean getInstanceFromEntity(CartCommodity cartCommodity, List<CommodityDiscountStrategy> commodityDiscountStrategies) {
        String strategyTitle = "";
        String  strategyType = "";
        Long  strategyAchivement = 0L;

        String commditiyTitle = cartCommodity.getCommodity().getCommditiyTitle();
            double originalPrice = cartCommodity.getCommodity().getPrice();
            String priceCurrency = cartCommodity.getCommodity().getPriceCurrency();
            long   numberOfCommodityOrdered = cartCommodity.getNumberOfCommodityOrdered();
            double totalPriceWithoutDiscount = originalPrice * numberOfCommodityOrdered;
        if(commodityDiscountStrategies.size() > 0 ) {
             strategyTitle = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyTitle();
             strategyType = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyType();
            strategyAchivement = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyAchivement();
        }
            return  new CartCommodityDiscountItemBean(commditiyTitle,originalPrice,priceCurrency,numberOfCommodityOrdered,totalPriceWithoutDiscount,strategyTitle,strategyType,strategyAchivement);
        }

    }

