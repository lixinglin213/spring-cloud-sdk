package com.thunisoft.msp.sdk.config.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixinglin
 * @description
 * @create 2019/10/8 4:04 下午
 * @since jdk 1.8
 */

@Configuration
@EnableConfigurationProperties({MonitorProperties.class})
public class MonitorConfigure {

    @Autowired
    private WebEndpointProperties webEndpointProperties;

    @Autowired
    private HealthEndpointProperties healthEndpointProperties;

    @Autowired
    private MonitorProperties monitorProperties;

    @Bean
    public void monitorHandler() {
        if (monitorProperties.getInclude().size() > 0) {
            webEndpointProperties.getExposure().setInclude(monitorProperties.getInclude());
        }
        if (monitorProperties.getExclude().size() > 0) {
            webEndpointProperties.getExposure().setExclude(monitorProperties.getExclude());
        }
        healthEndpointProperties.setShowDetails(monitorProperties.getShowDetails());

    }

}
