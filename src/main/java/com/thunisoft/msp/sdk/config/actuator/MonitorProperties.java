package com.thunisoft.msp.sdk.config.actuator;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.boot.actuate.health.ShowDetails;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lixinglin
 * @description
 * @create 2019/10/8 4:02 下午
 * @since jdk 1.8
 */
@ConfigurationProperties(prefix = "msp.monitor.actuator")
@Setter
@Getter
public class MonitorProperties {

    private Set<String> include = new LinkedHashSet<>();

    private Set<String> exclude = new LinkedHashSet<>();

    private ShowDetails showDetails = ShowDetails.NEVER;

}
