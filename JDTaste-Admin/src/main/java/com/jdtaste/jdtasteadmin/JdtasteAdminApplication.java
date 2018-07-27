package com.jdtaste.jdtasteadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.jdtaste" })
@SpringBootApplication
public class JdtasteAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdtasteAdminApplication.class, args);
	}
}
