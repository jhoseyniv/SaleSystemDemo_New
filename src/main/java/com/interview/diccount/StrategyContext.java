package com.interview.diccount;

import com.interview.beans.DiscountStrategyBean;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;

public class StrategyContext {
    private Discount strategy;

    public StrategyContext(Discount strategy) {
        this.strategy = strategy;
    }

    public DiscountStrategyBean applyStrategy(Commodity commodity, CommodityDiscountStrategy discountStrategy) {
        return  strategy.dicountCalculation(commodity,discountStrategy);
    }
}

