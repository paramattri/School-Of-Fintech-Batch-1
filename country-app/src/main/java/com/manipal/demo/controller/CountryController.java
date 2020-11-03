package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.Country;
import com.manipal.demo.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/countries/add")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		return countryService.getAllCountries();
	}
	
	@GetMapping("/countries/{id}")
	public Country getCountry(@PathVariable Integer id) {
		return countryService.getCountry(id);
	}
}
