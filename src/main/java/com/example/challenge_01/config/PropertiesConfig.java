package com.example.challenge_01.config;

import com.example.challenge_01.config.properties.SeoulOpenApiWifiInfoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
    @Bean
    @ConfigurationProperties("wifi-info")
    public SeoulOpenApiWifiInfoProperties seoulOpenApiWifiInfoProperties(){
        return new SeoulOpenApiWifiInfoProperties();
    }
}
