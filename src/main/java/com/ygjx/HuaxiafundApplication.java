package com.ygjx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ygjx.*.dao")
@EnableTransactionManagement
public class HuaxiafundApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuaxiafundApplication.class, args);
	}

}
