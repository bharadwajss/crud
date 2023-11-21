package com.ibm.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		System.out.println("This is my first crud");
		SpringApplication.run(CrudApplication.class, args);
	}

}
