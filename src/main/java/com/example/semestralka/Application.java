package com.example.semestralka;

import com.example.semestralka.configuration.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class Application {

    public static Config config = new Config();

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);

        Properties properties = new Properties();
        properties.put("spring.datasource.url", config.getPropertyStr("mysql.url"));
        properties.put("spring.datasource.username", config.getPropertyStr("mysql.username"));
        properties.put("spring.datasource.password", config.getPropertyStr("mysql.password"));
        application.setDefaultProperties(properties);

        application.run(args);
    }

}
