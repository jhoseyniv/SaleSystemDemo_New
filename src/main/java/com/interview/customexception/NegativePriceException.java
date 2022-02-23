package com.interview.customexception;

//File Name InsufficientFundsException.java
import java.io.*;

public class NegativePriceException extends Exception
{
   private double price;
   private String  message;
   public NegativePriceException(String message,double price)
   {
      super(message + ":" + price);
      this.price = price;
   } 

}
