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

            PercentStrategyDiscountBean percentItem = new PercentStrategyDiscountBean(item.getCommodityId(),item.getCommditiyTitle(),item.getOriginalPrice(),
                    item.getPriceCurrency(),item.getNumberOfCommodityOrdered(),item.getTotalPriceWithoutDiscount(),item.getStrategyTitle(),item.getMinNumberOfCommdityMeetDiscount(),
                    item.getStrategyAchivement(),totalPriceAfterDiscount);
            cartDisountBeanList.add(percentItem);
        }

        return cartDisountBeanList;
    }

    public static List<GiftStrategyDiscountBean> calcualteGiftStrategy (Map<String, List<CartCommodityDiscountItemBean> > groupedItems) {
        List<GiftStrategyDiscountBean> cartGiftBeanList = new ArrayList<GiftStrategyDiscountBean>() ;
        Iterator<Map.Entry<String, List<CartCommodityDiscountItemBean>> > i = groupedItems.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String,  List<CartCommodityDiscountItemBean>> item = i.next();
            String key = item.getKey();
            List<CartCommodityDiscountItemBean> items = item.getValue();
          //  System.out.println(key + " ---" + items.toString());
//            GiftStrategyDiscountBean giftStrategyDiscountBean = new GiftStrategyDiscountBean(item.getCommodityId(),item.getCommditiyTitle(),item.getOriginalPrice(),
//                    item.getPriceCurrency(),item.getNumberOfCommodityOrdered(),item.getTotalPriceWithoutDiscount(),item.getStrategyTitle(),item.getMinNumberOfCommdityMeetDiscount(),item.getStrategyAchivement(),item.getStrategyType());
//            cartGiftBeanList.add(giftStrategyDiscountBean);
        }
            return cartGiftBeanList;
    }

}
