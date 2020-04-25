package com.cloud.cloudconfig.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
public class ClientConfigEndpoint {

    @Value("${employeeService.request.timeout.milliseconds}")
    private String requestTimeout;

    @Value("${employeeService.connection.timeout.milliseconds}")
    private String connectionTimeout;

    @Value("${employeeService.http.maxpoolsize}")
    private String maxpoolsize;

    @Value("${employeeService.socket.timeout.milliseconds}")
    private String readtimeout;

    @GetMapping("/")
    public String getExpiryTime() {
        return new StringBuilder("Expiry time is:" + requestTimeout)
                .append("Connection time: " + connectionTimeout)
                .append("Maxpool size: " + maxpoolsize)
                .append("Read timeout: " + readtimeout)
                .toString();
    }


}
