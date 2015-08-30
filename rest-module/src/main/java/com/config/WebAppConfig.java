package com.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * Main web app configuration class
 * @author Gabriel
 */
@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @PostConstruct
    public void startDBManager() {
        //hsqldb
        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});

    }
}