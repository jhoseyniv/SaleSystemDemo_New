package com.interview.util;


import com.interview.dto.cart.GiftStrategyDiscountDTO;
import com.interview.dto.cart.PercentStrategyDiscountDTO;
import com.interview.dto.discount.CartCommodityDiscountItemDTO;
import com.interview.customexception.NegativePriceException;

import java.util.ArrayList;
import java.util.List;

public class DiscountUtitlty {
    public static List<PercentStrategyDiscountDTO> calculatePercentDiscountStrategy(List<CartCommodityDiscountItemDTO> items) throws NegativePriceException {
        List<PercentStrategyDiscountDTO> cartDisountBeanList = new ArrayList<PercentStrategyDiscountDTO>() ;
        for(CartCommodityDiscountItemDTO item : items){
            double totalPriceBeforDiscount = item.getTotalPriceWithoutDiscount();
            long   dicountPercent = item.getStrategyAchivement();

            double totalPriceAfterDiscount = totalPriceBeforDiscount - totalPriceBeforDiscount * dicountPercent /100;

            if(totalPriceAfterDiscount < 0 )
                    throw new NegativePriceException(" total Price can not be negative" , totalPriceAfterDiscount);

            PercentStrategyDiscountDTO percentItem = new PercentStrategyDiscountDTO(item.getCommodityId(), item.getStrategyTitle(),item.getMinNumberOfCommdityMeetDiscount(), item.getStrategyAchivement(),
                    item.getCommditiyTitle(),item.getOriginalPrice(),item.getPriceCurrency(),item.getNumberOfCommodityOrdered(),item.getTotalPriceWithoutDiscount(),totalPriceAfterDiscount);
            cartDisountBeanList.add(percentItem);
        }

        return cartDisountBeanList;
    }

    public static GiftStrategyDiscountDTO getGiftStrategyBean (List<CartCommodityDiscountItemDTO>  items) {
        GiftStrategyDiscountDTO giftStrategyDiscountBean = new GiftStrategyDiscountDTO() ;
        List<String> commodityRelatedWithStrategy= new ArrayList<String>();
        for(int i=0; i<items.size(); i++){
            CartCommodityDiscountItemDTO itemBean = items.get(i);
            commodityRelatedWithStrategy.add(itemBean.getCommditiyTitle());
        }
       if(items.size() > 0 ) {
            CartCommodityDiscountItemDTO item = items.get(0);
            long commodityMustBeGiftedId = item.getStrategyAchivement();
             giftStrategyDiscountBean = new GiftStrategyDiscountDTO(item.getStrategyTitle() ,item.getMinNumberOfCommdityMeetDiscount(),
                    commodityMustBeGiftedId,"-----",commodityRelatedWithStrategy);
         }
        return giftStrategyDiscountBean;
    }

}
