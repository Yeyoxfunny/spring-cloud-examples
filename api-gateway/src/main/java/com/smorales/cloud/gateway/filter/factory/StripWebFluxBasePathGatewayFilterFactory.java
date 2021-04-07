package com.smorales.cloud.gateway.filter.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * Remove basePath from outgoing request
 */
@Component
public class StripWebFluxBasePathGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StripWebFluxBasePathGatewayFilterFactory.class);

    private final String basePath;

    @Autowired
    public StripWebFluxBasePathGatewayFilterFactory(@Value("${spring.webflux.base-path}") String basePath) {
        this.basePath = basePath;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            String path = req.getURI().getRawPath();
            String newPath = path.replaceFirst(basePath, "");

            LOGGER.debug("Request Path: {}, new Path: {}", path, newPath);

            ServerHttpRequest request = req.mutate().path(newPath).contextPath(null).build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }
}
