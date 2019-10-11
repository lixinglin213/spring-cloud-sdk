package com.thunisoft.msp.sdk.config.registry;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @auther zhangkeshun
 * @Package${PCAKAGE_NAME}
 */
@ConfigurationProperties(prefix = "msp.registry")
@Setter
@Getter
public class RegistryProperties {

    /**consul agent hostname,Defaults to 'localhost'. */
    private String host = "localhost";

    /**Consul agent port. Defaults to '8500'. */
    private Integer port = 8500;

    /**Consul agent scheme (HTTP/HTTPS). If there is no scheme in address - client will use HTTP.*/
    private String scheme = "http";

    /**configuration for TLS.*/
    private ConsulProperties.TLSConfig tls;



    /**Use ip address rather than hostname during registration.*/
    private boolean preferIpAddress = true;

    /**IP address to use when accessing service (must also set preferIpAddress to use).*/
    private String ipAddress;

    /**Tags to use when registering service.*/
    private List<String> tags;

    /**Alternate server path to invoke for health checking.*/
    private String healthCheckPath = "/actuator/health";

    /**How often to perform the health check (e.g. 10s), defaults to 10s.*/
    private String healthCheckInterval = "10s";

    /**Unique service instance id. */
    private String instanceId;

    /**Is spring cloud consul enabled.*/
    private boolean enabled = true;

}
