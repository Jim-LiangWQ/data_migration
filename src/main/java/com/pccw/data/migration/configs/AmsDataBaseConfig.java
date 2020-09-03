package com.pccw.data.migration.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:22
 **/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryAms", // 配置连接工厂
        transactionManagerRef = "transactionManagerAms", // 配置事物管理器
        basePackages = {"com.pccw.data.migration.repository.ams"} // 设置dao所在位置

)
public class AmsDataBaseConfig {

    // 配置数据源
    @Autowired
    @Qualifier("amsDataSource")
    private DataSource amsDataSource;

    @Bean(name = "entityManagerFactoryAms")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryAms(EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(amsDataSource)
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.pccw.data.migration.entity.ams")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后 EntityManager 就可以针对数据库执行操作
                .persistenceUnit("amsPersistenceUnit")
                .build();

    }

    /**
     * 配置事物管理器
     *
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerAms")
    PlatformTransactionManager transactionManagerAms(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryAms(builder).getObject());
    }
}

