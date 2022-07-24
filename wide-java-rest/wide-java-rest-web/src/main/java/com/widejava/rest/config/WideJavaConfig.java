package com.widejava.rest.config;

import com.widejava.configuration.hibernate.WideJavaHibernateConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@SuppressWarnings("SpellCheckingInspection")
@ComponentScan(basePackages = { "com.widejava" })
@Import({ WideJavaHibernateConfig.class })
public class WideJavaConfig {

}
