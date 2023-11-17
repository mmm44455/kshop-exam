package com.vti.kshop_exam;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KshopExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(KshopExamApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}
}
