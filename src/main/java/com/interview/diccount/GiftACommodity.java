package com.interview.diccount;

import com.interview.beans.commodity.DiscountStrategyBean;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;


public class GiftACommodity implements Discount {

    @Override
    public DiscountStrategyBean dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy) {
        double currentPrice = commodity.getPrice();
        String  priceCurrenct = commodity.getPriceCurrency();
        DiscountStrategyBean discountStrategyBean = new DiscountStrategyBean(discountStrategy.getDiscountStrategy().getStrategyTitle(),  "You can Gift on this Item ",currentPrice,priceCurrenct);
        return  discountStrategyBean;
    }
}
