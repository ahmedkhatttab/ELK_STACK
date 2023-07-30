package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDateTime now = LocalDateTime.now();
		LocalDate dateOnly = now.toLocalDate();
		log.info("--------------------------------------");
		log.warn("{} => ", now);
		log.warn("{} => ", dateOnly);
		log.info("--------------------------------------");


	}

}
