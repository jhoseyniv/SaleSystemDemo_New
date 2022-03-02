package com.interview.diccount;

import com.interview.dto.commodity.DiscountStrategyDTO;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;
import com.interview.entity.DiscountStrategy;


public class DiscountACommodity implements Discount {
    @Override
    public DiscountStrategyDTO dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy) {
        double currentPrice = commodity.getPrice();
        String  priceCurrenct = commodity.getPriceCurrency();
        DiscountStrategy discountPercent = discountStrategy.getDiscountStrategy();
        Long percent =  discountPercent.getStrategyAchivement();
        String strategyTitle = discountStrategy.getDiscountStrategy().getStrategyTitle();
        double newPrice = currentPrice -  currentPrice * percent / 100 ;
        DiscountStrategyDTO discountStrategyBean = new DiscountStrategyDTO(strategyTitle, percent + "%  Discount apply on this Item",newPrice,priceCurrenct);
        return  discountStrategyBean;

        //return "Discount Strategy applied to " + commodity.getCommditiyTitle() + ":  " + discountStrategy.getDiscountStrategy().getStrategyTitle();
    }
}
