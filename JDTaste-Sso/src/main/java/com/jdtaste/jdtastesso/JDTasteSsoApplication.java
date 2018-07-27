package com.jdtaste.jdtastesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
@ServletComponentScan
@ComponentScan({ "com.jdtaste" })
@SpringBootApplication
public class JDTasteSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JDTasteSsoApplication.class, args);
	}
}
