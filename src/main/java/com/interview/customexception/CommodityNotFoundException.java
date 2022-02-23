package com.interview.customexception;

public class CommodityNotFoundException extends  RuntimeException {

    private String commodityTitle;
    private String  message;

    public CommodityNotFoundException(String commodityTitle, String message) {
        super(String.format("Commodity with title "+ commodityTitle +" not found"));
        this.commodityTitle = commodityTitle;
    }
}
