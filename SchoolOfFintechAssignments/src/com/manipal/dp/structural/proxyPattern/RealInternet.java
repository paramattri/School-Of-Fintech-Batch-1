package com.manipal.dp.structural.proxyPattern;

public class RealInternet implements Internet 
{ 
    @Override
    public void connectTo(String serverhost) 
    { 
        System.out.println("Connecting to "+ serverhost); 
    }
    
} 