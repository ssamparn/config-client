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

    @Value("${service.cache.expiryTime.seconds.test}")
    private String expiryTime;

    @Value("${service.connection.timeout.milliseconds.test}")
    private String connectionTime;

    @Value("${service.http.maxpoolsize.test}")
    private String maxpoolsize;

    @Value("${service.read.timeout.milliseconds.test}")
    private String readtimeout;

    @GetMapping("/")
    public String getExpiryTime() {
        return new StringBuilder("Expiry time is:" + expiryTime)
                .append("Connection time: " + connectionTime)
                .append("Maxpool size: " + maxpoolsize)
                .append("Read timeout: " + readtimeout)
                .toString();
    }


}
