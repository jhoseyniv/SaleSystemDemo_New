package com.interview.customexception;

//File Name InsufficientFundsException.java
import java.io.*;

public class NegativePriceException extends RuntimeException
{
   private double price;
   private String  message;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   @Override
   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public NegativePriceException(String message, double price)
   {
      super(String.format("Price with Negative Value %d not acceptable", price));
      this.price = price;
   } 

}
