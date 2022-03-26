package com.step.shophome;

import com.step.shophome.config.mysql.Mysql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		Mysql.init();
		SpringApplication.run(ShopApplication.class, args);

	}

}
