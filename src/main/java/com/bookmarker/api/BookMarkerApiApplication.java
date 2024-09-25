package com.bookmarker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class BookMarkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMarkerApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<?> corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
		configuration.setAllowedMethods(Arrays.asList("POST", "DELETE", "GET", "PATCH", "PUT"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		FilterRegistrationBean<?> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
}
