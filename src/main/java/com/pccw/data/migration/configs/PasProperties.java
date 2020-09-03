package com.pccw.data.migration.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Created by Jim@80992399 on 2020-08-07 10:34
 **/
@ConfigurationProperties(prefix = "spring.datasource.pas")
@Component
@Data
public class PasProperties {
    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
