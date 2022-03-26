package com.rb.alwaysontheroad.empty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    public static final String V_3_API_DOCS = "/v3/api-docs/**";
    public static final String WEBJARS_SWAGGER_UI = "/webjars/swagger-ui/**";
    public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
    public static final String SWAGGER_UI = "/swagger-ui/**";

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(final ServerHttpSecurity http) {

        http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .pathMatchers("/actuator/**").permitAll()
                        .pathMatchers(V_3_API_DOCS, SWAGGER_UI, WEBJARS_SWAGGER_UI, SWAGGER_UI_HTML).permitAll()
                        .anyExchange().authenticated()
                );

        http
                .oauth2Login(withDefaults());

        return http
                .csrf().disable()
                .build();
    }
}
