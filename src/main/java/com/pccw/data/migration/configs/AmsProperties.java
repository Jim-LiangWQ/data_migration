package com.pccw.data.migration.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:15
 **/

@ConfigurationProperties(prefix = "spring.datasource.ams")
@Component
@Data
public class AmsProperties {
    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
