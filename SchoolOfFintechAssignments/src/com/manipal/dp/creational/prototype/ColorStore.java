package com.manipal.dp.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ColorStore { 
	   
    private static Map<String, Color> colorMap = new HashMap<String, Color>();  
       
    static 
    { 
        colorMap.put("blue", new BlueColor()); // Storing Prototype Objects
        colorMap.put("black", new BlackColor()); // Storing Prototype Objects 
    } 
       
    public static Color getColor(String colorName) 
    { 
        return (Color) colorMap.get(colorName).clone(); 
    } 
}