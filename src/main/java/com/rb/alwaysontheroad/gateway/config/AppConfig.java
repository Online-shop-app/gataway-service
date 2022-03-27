package com.rb.alwaysontheroad.gateway.config;

import io.netty.handler.logging.LogLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    public HttpClient httpClient(AppProps appProps) {
        AppProps.HttpClient clientProps = appProps.getHttpClient();

        return HttpClient.create(ConnectionProvider.builder("fixed")
                        .maxConnections(clientProps.getMaxConnections())
                        .maxIdleTime(Duration.ofMillis(clientProps.getMaxIdleTime()))
                        .maxLifeTime(Duration.ofMillis(clientProps.getMaxLifeTime()))
                        .pendingAcquireTimeout(Duration.ofMillis(clientProps.getPendingAcquireTimeout()))
                        .evictInBackground(Duration.ofMillis(clientProps.getEvictInBackground()))
                        .build()
                )
                .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL, StandardCharsets.UTF_8);
    }
}
