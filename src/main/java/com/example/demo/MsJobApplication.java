package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsJobApplication.class, args);
	}
	@Bean
	ApplicationRunner init (JobRepository repository) {
		return args ->{
			repository.save(new Job("Ingenieur informatique",true));
			repository.save(new Job("Commercial",false));
			repository.findAll().forEach(System.out::println);
		};
}
}