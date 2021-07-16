package com.newtonic.SpringShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.sql.DataSource;

/**
 * TODO: write you class description here
 *
 * @author
 */

@EnableAuthorizationServer
@SpringBootApplication
public class SpringShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}

}
