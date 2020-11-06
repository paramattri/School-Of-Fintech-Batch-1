package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.ConversionRate;

@RestController
public class UnitConversionController {
	
	@Autowired
	private Environment environment;
//	@GetMapping("unit-conversion/from/{fromUnit}/to/{toUnit}")
//	public Double getConversionRate(@PathVariable String fromUnit, @PathVariable String toUnit) {
//		
//		ConversionRate conversionRate = new ConversionRate(fromUnit, toUnit, 1000);
//		return 1000.00;
//	}
	
	@GetMapping("unit-conversion/from/{fromUnit}/to/{toUnit}")
	public ConversionRate getConversionRate(@PathVariable String fromUnit, @PathVariable String toUnit) {
		
		String port = environment.getProperty("server.port");
		ConversionRate conversionRate = new ConversionRate(fromUnit, toUnit, 1000, port);
		return conversionRate;
	}
	
}
