package com.interview.customexception;

//File Name InsufficientFundsException.java
import java.io.*;

public class NegativePriceException extends RuntimeException
{
   private double price;
   private String  message;
   public NegativePriceException(String message,double price)
   {
      super(String.format("Price with Negative Value %d not acceptable", price));
      this.price = price;
   } 

}
