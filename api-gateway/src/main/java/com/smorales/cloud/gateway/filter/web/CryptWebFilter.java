package com.smorales.cloud.gateway.filter.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

public class CryptWebFilter implements WebFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryptWebFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        LOGGER.info("Filter CryptWebFilter");

        return chain.filter(exchange);
    }

}
