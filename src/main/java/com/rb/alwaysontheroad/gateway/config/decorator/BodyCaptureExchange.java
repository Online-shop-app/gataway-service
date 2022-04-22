package com.rb.alwaysontheroad.gateway.config.decorator;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

public class BodyCaptureExchange extends ServerWebExchangeDecorator {

    private final BodyCaptureRequest bodyCaptureRequest;
    private final BodyCaptureResponse bodyCaptureResponse;

    public BodyCaptureExchange(ServerWebExchange exchange) {
        super(exchange);
        this.bodyCaptureRequest = new BodyCaptureRequest(exchange.getRequest());
        this.bodyCaptureResponse = new BodyCaptureResponse(exchange.getResponse());
    }

    @NotNull
    @Override
    public BodyCaptureRequest getRequest() {
        return bodyCaptureRequest;
    }

    @NotNull
    @Override
    public BodyCaptureResponse getResponse() {
        return bodyCaptureResponse;
    }
}
