package com.example.oauth.oauthkeycloak.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter=new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
        httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
                .oauth2ResourceServer(rsc-> rsc.jwt(
                        jwtConfigurer -> {
                            jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter);
                        }
                ));

        return httpSecurity.build();
    }

}
