package com.rb.alwaysontheroad.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties(prefix = "com.rb.alwaysontheroad.gateway")
public class AppProps {

    @NotNull
    private HttpClient httpClient;

    @Getter
    @Setter
    public static class HttpClient {
        @NotNull
        @Positive
        private Integer maxConnections;
        @NotNull
        @Positive
        private Long maxIdleTime;
        @NotNull
        @Positive
        private Long maxLifeTime;
        @NotNull
        @Positive
        private Long pendingAcquireTimeout;
        @NotNull
        @Positive
        private Long evictInBackground;
    }
}

