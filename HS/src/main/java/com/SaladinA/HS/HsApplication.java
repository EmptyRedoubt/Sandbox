package com.SaladinA.HS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SaladinA.HS.model.Person;

/**
 * This application is a RESTful Web Services that allows a CSV file to be
 * imported, converted into useable data, and accessed at
 * localhost:8080/personlist
 * 
 * @author Amber Saladin
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.SaladinA")
public class HsApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(HsApplication.class, args);
	}
}
