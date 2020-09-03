package com.pccw.data.migration.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:13
 **/

@ConfigurationProperties(prefix = "spring.datasource.ars")
@Component
@Data
public class ArsProperties {
    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
