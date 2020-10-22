package com.manipal.dp.structural.bridgePattern;

//Concrete implementation 1 for bridge pattern 
public class Produce implements Workshop { 
 @Override
 public void work() 
 { 
     System.out.print("Produced"); 
 } 
} 