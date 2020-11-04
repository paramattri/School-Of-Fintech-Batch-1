package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.Country;
import com.manipal.demo.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/countries")
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
	
	@PutMapping("/countries/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable int id, @RequestBody Country countryDetails) {
		
		Country country = countryService.getCountry(id);
		country.setName(countryDetails.getName());
		country.setPopulation(countryDetails.getPopulation());
		country.setCapital(countryDetails.getCapital());
		country.setLanguage(countryDetails.getLanguage());
		
		Country countryUpdated = countryService.addCountry(country);
		
		return ResponseEntity.ok(countryUpdated);
	}
	
	@DeleteMapping("/countries/{id}")
	public String deleteCountry(@PathVariable Integer id) {
		Country country = countryService.getCountry(id);
		countryService.deleteCountry(id);
		return "Record Deleted";
	}
	
	@GetMapping("/countries/country/{countryName}")
	public Country getCountryByName(@PathVariable String countryName){
		
		return countryService.getCountryByName(countryName);
	}
	
	@GetMapping("/countries/language/{language}")
	public List<Country> getCountriesByLanguage(@PathVariable String language){
		
		return countryService.getCountriesByLanguage(language);
	}
	
	@GetMapping("/countries/population/{population}")
	public List<Country> getCountriesByPopulationGreater(@PathVariable Integer population){
		
		return countryService.getCountriesByPopulationGreater(population);
	}
	
}
