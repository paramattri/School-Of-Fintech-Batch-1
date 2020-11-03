package com.manipal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.demo.beans.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
