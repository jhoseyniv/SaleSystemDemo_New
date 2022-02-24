package com.interview.customexception;

public class CommodityNotFoundException extends  RuntimeException {

    private String commodityTitle;
    private String  message;

    public String getCommodityTitle() {
        return commodityTitle;
    }

    public void setCommodityTitle(String commodityTitle) {
        this.commodityTitle = commodityTitle;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommodityNotFoundException(String commodityTitle, String message) {
        this.commodityTitle = commodityTitle;
        this.message =  message;
    }
}
