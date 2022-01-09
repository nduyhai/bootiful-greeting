package com.bootiful.greeting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  protected static final String[] PUBLIC_ENDPOINTS = {
    "/v3/api-docs",
    "/v3/api-docs/**",
    "/swagger-ui.html",
    "/swagger-ui/**",
    "/actuator",
    "/actuator/**"
  };

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .disable()
        .csrf()
        .disable()
        .sessionManagement()
        .disable()
        .anonymous()
        .and()
        .authorizeHttpRequests()
        .antMatchers(PUBLIC_ENDPOINTS)
        .permitAll()
        .antMatchers(HttpMethod.GET, "/greeting")
        .permitAll()
        .and()
        .authorizeHttpRequests()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt();
  }
}
