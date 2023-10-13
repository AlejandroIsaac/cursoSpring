package com.platzi.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class CursoApplication {

	@GetMapping("/")
	String home(){
		return "Hola mundo";
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}
