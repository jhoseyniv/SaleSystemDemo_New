package com.interview.diccount;

import com.interview.beans.DiscountStrategyBean;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;

public interface Discount {
    public DiscountStrategyBean dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy);
}