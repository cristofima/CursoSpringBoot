package com.musc.kanban;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSpringApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-5:00"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

}
