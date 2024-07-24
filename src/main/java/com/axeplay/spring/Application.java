package com.axeplay.spring;

import com.axeplay.spring.service.CatSound;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		try {
			CatSound catSound = (CatSound) ctx.getBean("dog");

			System.out.println(catSound.sound());
		} catch (Exception e) {
			//ignore
		}
	}

}
