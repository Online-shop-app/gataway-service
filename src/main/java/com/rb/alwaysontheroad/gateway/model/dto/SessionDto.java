package com.rb.alwaysontheroad.gateway.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SessionDto {

    @JsonProperty("session_id")
    private String sessionId;
}
