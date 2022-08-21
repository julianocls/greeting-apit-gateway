package br.com.jcls.greetingapigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LogginFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("Info: Original request path -> {}", exchange.getRequest().getPath());
        log.error("Error: Original request path -> {}", exchange.getRequest().getPath());
        log.debug("Debug: Original request path -> {}", exchange.getRequest().getPath());

        return chain.filter(exchange);
    }

}
