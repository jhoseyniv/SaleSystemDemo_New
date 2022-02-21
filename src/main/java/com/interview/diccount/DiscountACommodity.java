package com.interview.diccount;

import com.interview.beans.DiscountStrategyBean;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;
import com.interview.entity.DiscountStrategy;


public class DiscountACommodity implements Discount {
    @Override
    public DiscountStrategyBean dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy) {
        double currentPrice = commodity.getPrice();
        String  priceCurrenct = commodity.getPriceCurrency();
        DiscountStrategy discountPercent = discountStrategy.getDiscountStrategy();
        Long percent =  discountPercent.getStrategyAchivement();
        String strategyTitle = discountStrategy.getDiscountStrategy().getStrategyTitle();
        double newPrice = currentPrice -  currentPrice * percent / 100 ;
        DiscountStrategyBean discountStrategyBean = new DiscountStrategyBean(strategyTitle, percent + "%  Discount apply on this Item",newPrice,priceCurrenct);
        return  discountStrategyBean;

        //return "Discount Strategy applied to " + commodity.getCommditiyTitle() + ":  " + discountStrategy.getDiscountStrategy().getStrategyTitle();
    }
}
