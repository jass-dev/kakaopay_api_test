package com.kakaopay.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kakaopay.api.controller.FlexController;

@SpringBootApplication
@MapperScan(basePackages = "com.kakaopay.api")
public class KakaopayHomePjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaopayHomePjtApplication.class, args);
	}

}
