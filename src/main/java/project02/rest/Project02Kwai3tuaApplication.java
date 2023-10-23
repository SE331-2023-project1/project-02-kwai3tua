package project02.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Project02Kwai3tuaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project02Kwai3tuaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings (CorsRegistry registry){
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000")
						.exposedHeaders("x-total-count") //expose x-total-count
						.allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
						.allowCredentials(true)
						.allowedHeaders("Origin","Authorization","application/json","Content-Type");
			}
		};
	}
}


