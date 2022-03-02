package com.interview.diccount;

import com.interview.dto.commodity.DiscountStrategyDTO;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;


public class GiftACommodity implements Discount {

    @Override
    public DiscountStrategyDTO dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy) {
        double currentPrice = commodity.getPrice();
        String  priceCurrenct = commodity.getPriceCurrency();
        DiscountStrategyDTO discountStrategyBean = new DiscountStrategyDTO(discountStrategy.getDiscountStrategy().getStrategyTitle(),  "You can Gift on this Item ",currentPrice,priceCurrenct);
        return  discountStrategyBean;
    }
}
