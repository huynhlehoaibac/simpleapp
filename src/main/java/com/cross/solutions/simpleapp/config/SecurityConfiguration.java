package com.cross.solutions.simpleapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author huynhlehoaibac
 * @since 0.0.1-SNAPSHOT
 */
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeRequests(
            authorize -> {
              authorize.antMatchers("cart").hasAnyAuthority("SCOPE_openid", "SCOPE_cart");
              authorize.anyRequest().authenticated();
            })
        .oauth2Login(Customizer.withDefaults());
    return http.build();
  }
}
