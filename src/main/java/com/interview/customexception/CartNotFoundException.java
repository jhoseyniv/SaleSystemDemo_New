package com.interview.customexception;

public class CartNotFoundException extends  RuntimeException {

    private String cartTitle;
    private String  message;

    public CartNotFoundException(String cartTitle, String message) {
        super(String.format("Cart with title "+ cartTitle +" not found"));
        this.cartTitle = cartTitle;
    }
}
