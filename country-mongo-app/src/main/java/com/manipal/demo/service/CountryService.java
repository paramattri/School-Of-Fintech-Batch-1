package com.manipal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.beans.Country;
import com.manipal.demo.exception.CountryNotFoundException;
import com.manipal.demo.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public Country addCountry(Country country) {
		return countryRepository.save(country);
	}
	
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}
	
	public Country getCountry(int id) {
		return countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException("Country Details not found for id "+id));
	}
	
	public void deleteCountry(Integer id) {
		countryRepository.deleteById(id);
	}
	
	public Country getCountryByName(String countryName){
		return countryRepository.findByName(countryName);		
	}
	
	public List<Country> getCountriesByLanguage(String language){
		return countryRepository.findByLanguage(language);
	}
	
	public List<Country> getCountriesByPopulationGreater(Integer population){
		return countryRepository.findByPopulationGreater(population);
	}

}
