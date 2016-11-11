package com.ssdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

public class TravelWebAppApplication {

	/*@ResponseBody
	@RequestMapping("/")
	String demo(){
		return "My Spring boot App";
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(TravelWebAppApplication.class, args);
	}
}
