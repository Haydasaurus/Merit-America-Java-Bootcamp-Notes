package com.meritamerica.jpatest;

import com.meritamerica.jpatest.dao.CustomerRepository;
import com.meritamerica.jpatest.dao.PersonRepository;
import com.meritamerica.jpatest.model.Customer;
import com.meritamerica.jpatest.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, CustomerRepository customerRepository) {
		return (args) -> {
			// save a couple of persons
			personRepository.save(new Person("Jack", "Bauer"));
			personRepository.save(new Person("Chloe", "O'Brian"));
			personRepository.save(new Person("Kim", "Bauer"));
			personRepository.save(new Person("David", "Palmer"));
			personRepository.save(new Person("Michelle", "Dessler"));


			customerRepository.save(new Customer("Tom", "Jones", "New York"));
			customerRepository.save(new Customer("Tom", "Hanks", "Los Angeles"));
		};
	}

}