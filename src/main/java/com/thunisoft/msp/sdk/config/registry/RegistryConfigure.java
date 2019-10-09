package com.thunisoft.msp.sdk.config.registry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConsulAutoConfiguration;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * @author lixinglin
 * @description
 * @create 2019/9/10 3:08 下午
 * @since jdk 1.8
 */
@Configuration
@EnableConfigurationProperties({RegistryProperties.class})
@EnableDiscoveryClient
@AutoConfigureBefore(ConsulAutoConfiguration.class)
public class RegistryConfigure {

    @Autowired
    private RegistryProperties registryProperties;

    @Autowired
    private ConsulProperties consulProperties;

    @Autowired
    private ConsulDiscoveryProperties consulDiscoveryProperties;

    @Bean
    public void registryHandler() {
        consulProperties.setHost(registryProperties.getHost());
        consulProperties.setPort(registryProperties.getPort());
        consulDiscoveryProperties.setHealthCheckPath(registryProperties.getHealthCheckPath());
        consulDiscoveryProperties.setPreferIpAddress(registryProperties.isPreferIpAddress());
        consulDiscoveryProperties.setScheme(registryProperties.getScheme());

        if (StringUtils.isNotBlank(registryProperties.getInstanceId())) {
            consulDiscoveryProperties.setInstanceId(registryProperties.getInstanceId());
        }
        if (StringUtils.isNotBlank(registryProperties.getHealthCheckUrl())) {
            consulDiscoveryProperties.setHealthCheckUrl(registryProperties.getHealthCheckUrl());
        }
        if (StringUtils.isNotBlank(registryProperties.getIpAddress())) {
            consulDiscoveryProperties.setIpAddress(registryProperties.getIpAddress());
        }
        List<String> tags = registryProperties.getTags();
        tags.add("registerTime=" + System.currentTimeMillis());
        consulDiscoveryProperties.setTags(tags);
    }

}
