package com.koko.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * preference에서 gradle 빌드시 intelij를 쓰게 설정하면 더빠르다.
 */
@SpringBootApplication
public class IntroductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}

}
