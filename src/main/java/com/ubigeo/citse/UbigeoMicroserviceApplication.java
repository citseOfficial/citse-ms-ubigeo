package com.ubigeo.citse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class 	UbigeoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbigeoMicroserviceApplication.class, args);
	}

}
