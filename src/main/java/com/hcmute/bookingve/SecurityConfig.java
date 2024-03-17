package com.hcmute.bookingve;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth)->auth.
                        requestMatchers("/admin/**").hasAuthority("ADMIN").
                requestMatchers("/*").permitAll().
                anyRequest().authenticated())
                .formLogin(login->login.loginPage("/logon").loginProcessingUrl("/logon")
                        .usernameParameter("username").passwordParameter("password")
                        .defaultSuccessUrl("/admin", true));
        return http.build();
    }
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**", "/assets/**");
    }
}