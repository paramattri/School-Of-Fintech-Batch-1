package com.manipal.demo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
public class Country {
	
	@Id
	private int countryId;
	private String name;
	private int population;
	private String capital;
	private String language;
	
	public Country() {}
	
	public Country(int countryId, String name, int population, String capital, String language) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.population = population;
		this.capital = capital;
		this.language = language;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
