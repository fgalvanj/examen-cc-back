package com.cc.api;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cc.api.services.ArchivoService;

@SpringBootApplication
public class CcProjectBackApplication implements CommandLineRunner {
	
	@Resource
	ArchivoService archivoService;

	public static void main(String[] args) {
		SpringApplication.run(CcProjectBackApplication.class, args);
	}
	
	public void run(String... arg) throws Exception{
		archivoService.init();
		
	}

}
