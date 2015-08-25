package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Alexey Gabriel
 */
@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebAppConfig extends WebMvcConfigurerAdapter {

}