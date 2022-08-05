package com.widejava.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class WideJavaRestWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WideJavaRestWebApplication.class, args);
    }

}
