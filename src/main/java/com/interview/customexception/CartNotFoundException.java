package com.interview.customexception;

public class CartNotFoundException extends  RuntimeException {

    private String cartTitle;
    private String  message;

    public String getCartTitle() {
        return cartTitle;
    }

    public void setCartTitle(String cartTitle) {
        this.cartTitle = cartTitle;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CartNotFoundException(String cartTitle, String message) {
        this.cartTitle = cartTitle;
        this.message =  message;
    }
}
