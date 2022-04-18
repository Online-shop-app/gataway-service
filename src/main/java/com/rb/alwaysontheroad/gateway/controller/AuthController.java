package com.rb.alwaysontheroad.gateway.controller;

import com.rb.alwaysontheroad.gateway.controller.routes.Routes;
import com.rb.alwaysontheroad.gateway.model.dto.SessionDto;
import com.rb.alwaysontheroad.gateway.model.dto.TokenPairDto;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    @GetMapping(value = Routes.SESSION_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<SessionDto> session(@Parameter(hidden = true) WebSession webSession) {
        return Mono.just(new SessionDto().setSessionId(webSession.getId()));
    }

    @GetMapping(value = Routes.TOKEN_PAIR_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TokenPairDto> tokenPair(@Parameter(hidden = true) @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        return Mono.just(new TokenPairDto()
                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                .setRefreshToken(authorizedClient.getRefreshToken().getTokenValue())
        );
    }
}
