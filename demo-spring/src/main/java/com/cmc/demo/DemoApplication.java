package com.cmc.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cmc.demo.model.Customer;
import com.cmc.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication {

	/**
	 * main method for launching.
	 * 
	 * @param args
	 *            .
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);
	}

	@Bean
	public CommandLineRunner initData(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer("name 1","email 1","phone 1","address 1"));
			customerRepository.save(new Customer("name 2","email 2","phone 2","address 2"));
			customerRepository.save(new Customer("name 3","email 3","phone 3","address 3"));
		};
	}
	
	
}
