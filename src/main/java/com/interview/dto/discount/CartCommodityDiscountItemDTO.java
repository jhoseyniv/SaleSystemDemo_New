package com.interview.dto.discount;

import com.interview.entity.CartCommodity;
import com.interview.entity.CommodityDiscountStrategy;
import java.util.List;

public class CartCommodityDiscountItemDTO {
    private Long commodityId;
    private String commditiyTitle;
    private double originalPrice;
    private String priceCurrency;
    private long numberOfCommodityOrdered;
    private double totalPriceWithoutDiscount ;
    private String strategyTitle;
    private String strategyType;
    private Long   strategyAchivement;
    private Long   minNumberOfCommdityMeetDiscount;

    public String getCommditiyTitle() {
        return commditiyTitle;
    }

    public void setCommditiyTitle(String commditiyTitle) {
        this.commditiyTitle = commditiyTitle;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public double getNumberOfCommodityOrdered() {
        return numberOfCommodityOrdered;
    }

    public Long getCommodityId() {
        return commodityId;
    }



    public void setNumberOfCommodityOrdered(long numberOfCommodityOrdered) {
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
    }

    public double getTotalPriceWithoutDiscount() {
        return totalPriceWithoutDiscount;
    }

    public void setTotalPriceWithoutDiscount(double totalPriceWithoutDiscount) {
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public Long getStrategyAchivement() {
        return strategyAchivement;
    }

    public void setStrategyAchivement(Long strategyAchivement) {
        this.strategyAchivement = strategyAchivement;
    }

    public Long getMinNumberOfCommdityMeetDiscount() {
        return minNumberOfCommdityMeetDiscount;
    }

    public void setMinNumberOfCommdityMeetDiscount(Long minNumberOfCommdityMeetDiscount) {
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }

    public CartCommodityDiscountItemDTO() {
    }

    public CartCommodityDiscountItemDTO(Long commodityId, String commditiyTitle, double originalPrice, String priceCurrency,
                                        long numberOfCommodityOrdered, double totalPriceWithoutDiscount,
                                        String strategyTitle, String strategyType, Long strategyAchivement, Long minNumberOfCommdityMeetDiscount) {
        this.commodityId = commodityId;
        this.commditiyTitle = commditiyTitle;
        this.originalPrice = originalPrice;
        this.priceCurrency = priceCurrency;
        this.numberOfCommodityOrdered = numberOfCommodityOrdered;
        this.totalPriceWithoutDiscount = totalPriceWithoutDiscount;
        this.strategyTitle = strategyTitle;
        this.strategyType = strategyType;
        this.strategyAchivement = strategyAchivement;
        this.minNumberOfCommdityMeetDiscount = minNumberOfCommdityMeetDiscount;
    }
    public static CartCommodityDiscountItemDTO getInstanceFromEntity(CartCommodity cartCommodity, List<CommodityDiscountStrategy> commodityDiscountStrategies) {
        String strategyTitle = "";
        String  strategyType = "";
        Long  strategyAchivement = 0L;
        Long  minNumberOfCommdityMeetDiscount = 1L;

            Long commodityId = cartCommodity.getCommodity().getId();
            String commditiyTitle = cartCommodity.getCommodity().getCommditiyTitle();
            double originalPrice = cartCommodity.getCommodity().getPrice();
            String priceCurrency = cartCommodity.getCommodity().getPriceCurrency();
            long   numberOfCommodityOrdered = cartCommodity.getNumberOfCommodityOrdered();
            double totalPriceWithoutDiscount = originalPrice * numberOfCommodityOrdered;
        if(commodityDiscountStrategies.size() > 0 ) {
             strategyTitle = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyTitle();
             strategyType = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyType();
             strategyAchivement = commodityDiscountStrategies.get(0).getDiscountStrategy().getStrategyAchivement();
             minNumberOfCommdityMeetDiscount = commodityDiscountStrategies.get(0).getMinNumberOfCommdityMeetDiscount();
        }
            return  new CartCommodityDiscountItemDTO(commodityId,commditiyTitle,originalPrice,priceCurrency,numberOfCommodityOrdered,totalPriceWithoutDiscount,strategyTitle,strategyType,strategyAchivement,minNumberOfCommdityMeetDiscount);
        }

    }

