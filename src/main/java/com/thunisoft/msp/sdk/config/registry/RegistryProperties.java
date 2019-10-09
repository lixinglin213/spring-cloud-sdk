package com.thunisoft.msp.sdk.config.registry;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther zhangkeshun
 * @Package${PCAKAGE_NAME}
 */
@ConfigurationProperties(prefix = "msp.registry")
@Configuration
@Setter
@Getter
@Component
public class RegistryProperties {

    private List<String> tags;
    private String healthCheckUrl;
    private String healthCheckPath = "/actuator/health";
    private String host;
    private Integer port;
    private String instanceId;


    private boolean preferIpAddress = false;
    private String ipAddress;
    private String scheme = "http";
    private boolean enable;
}
