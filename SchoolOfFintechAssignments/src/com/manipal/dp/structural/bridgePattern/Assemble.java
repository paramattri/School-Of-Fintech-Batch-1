package com.manipal.dp.structural.bridgePattern;

//Concrete implementation 2 for bridge pattern 
public class Assemble implements Workshop { 
 @Override
 public void work() 
 { 
     System.out.print(" And"); 
     System.out.println(" Assembled."); 
 } 
}