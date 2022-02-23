package com.interview.util;


import com.interview.beans.cart.CartDisountBean;
import com.interview.beans.cart.GiftStrategyDiscountBean;
import com.interview.beans.cart.PercentStrategyDiscountBean;
import com.interview.beans.discount.CartCommodityDiscountItemBean;
import com.interview.customexception.NegativePriceException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DiscountUtitlty {
    public static List<PercentStrategyDiscountBean> calculatePercentDiscountStrategy(List<CartCommodityDiscountItemBean> items) throws NegativePriceException {
        List<PercentStrategyDiscountBean> cartDisountBeanList = new ArrayList<PercentStrategyDiscountBean>() ;
        for(CartCommodityDiscountItemBean item : items){
            double totalPriceBeforDiscount = item.getTotalPriceWithoutDiscount();
            long   dicountPercent = item.getStrategyAchivement();

            double totalPriceAfterDiscount = totalPriceBeforDiscount - totalPriceBeforDiscount * dicountPercent /100;

            if(totalPriceAfterDiscount < 0 )
                    throw new NegativePriceException(" total Price can not be negative" , totalPriceAfterDiscount);

            PercentStrategyDiscountBean percentItem = new PercentStrategyDiscountBean(item.getCommodityId(), item.getStrategyTitle(),item.getMinNumberOfCommdityMeetDiscount(), item.getStrategyAchivement(),
                    item.getCommditiyTitle(),item.getOriginalPrice(),item.getPriceCurrency(),item.getNumberOfCommodityOrdered(),item.getTotalPriceWithoutDiscount(),totalPriceAfterDiscount);
            cartDisountBeanList.add(percentItem);
        }

        return cartDisountBeanList;
    }

    public static GiftStrategyDiscountBean getGiftStrategyBean (List<CartCommodityDiscountItemBean>  items) {
        GiftStrategyDiscountBean giftStrategyDiscountBean = new GiftStrategyDiscountBean() ;
        List<String> commodityRelatedWithStrategy= new ArrayList<String>();
        for(int i=0; i<items.size(); i++){
            CartCommodityDiscountItemBean itemBean = items.get(i);
            commodityRelatedWithStrategy.add(itemBean.getCommditiyTitle());
        }
       if(items.size() > 0 ) {
            CartCommodityDiscountItemBean item = items.get(0);
            long commodityMustBeGiftedId = item.getStrategyAchivement();
             giftStrategyDiscountBean = new GiftStrategyDiscountBean(item.getStrategyTitle() ,item.getMinNumberOfCommdityMeetDiscount(),
                    commodityMustBeGiftedId,"-----",commodityRelatedWithStrategy);
         }
        return giftStrategyDiscountBean;
    }

}
