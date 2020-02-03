package com.pmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pmm")
public class PmmApplication {

	public static void main(String args[]) {
		SpringApplication.run(PmmApplication.class, args);
	}
}
