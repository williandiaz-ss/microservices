package com.sanservices.test.microservices.api_gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogginFilter implements GlobalFilter {

    private Logger log = LoggerFactory.getLogger(LogginFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Path of the request received -> {}", exchange.getRequest().getPath().toString());

        return chain.filter(exchange);
    }
}
