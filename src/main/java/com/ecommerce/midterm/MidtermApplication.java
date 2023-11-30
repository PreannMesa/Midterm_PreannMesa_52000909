package com.ecommerce.midterm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MidtermApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidtermApplication.class, args);
    }

}
