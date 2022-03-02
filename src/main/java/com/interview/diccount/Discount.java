package com.interview.diccount;

import com.interview.dto.commodity.DiscountStrategyDTO;
import com.interview.entity.Commodity;
import com.interview.entity.CommodityDiscountStrategy;

public interface Discount {
    public DiscountStrategyDTO dicountCalculation(Commodity commodity, CommodityDiscountStrategy discountStrategy);
}