package com.manipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manipal.service.TwitterData;


@SpringBootApplication
public class Twitter4jTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Twitter4jTestApplication.class, args);
	}

}
