package com.smorales.cloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.smorales.cloud.gateway.filter.web.CryptWebFilter;

@EnableWebFluxSecurity
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable()
                .authorizeExchange()
                .anyExchange()
                .permitAll()
                .and()
                .addFilterAfter(new CryptWebFilter(), SecurityWebFiltersOrder.REACTOR_CONTEXT);
        return http.build();
    }

}
