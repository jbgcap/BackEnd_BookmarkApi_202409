package com.bookmarker.api;

import org.springframework.boot.SpringApplication;

public class TestBookMarkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookMarkerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
