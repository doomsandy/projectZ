package com.application.security;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
@org.springframework.cloud.openfeign.FeignClient(name = "feign-client", url = "http://localhost:8079")
public interface FeignClient {

    @PostMapping(value = "/lego", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> sendJtiToStub(@RequestBody Map<String, String> request);
}


