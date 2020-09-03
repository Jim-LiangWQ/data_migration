package com.pccw.data.migration.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:19
 **/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryArs", // 配置连接工厂
        transactionManagerRef = "transactionManagerArs", // 配置事物管理器
        basePackages = {"com.pccw.data.migration.repository.ars"} // 设置dao所在位置

)
public class ArsDataBaseConfig {

    // 配置数据源
    @Autowired
    @Qualifier("arsDataSource")
    private DataSource arsDataSource;

    @Primary
    @Bean(name = "entityManagerFactoryArs")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryArs(EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(arsDataSource)
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.pccw.data.migration.entity.ars")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后 EntityManager 就可以针对数据库执行操作
                .persistenceUnit("arsPersistenceUnit")
                .build();

    }

    /**
     * 配置事物管理器
     *
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerArs")
    PlatformTransactionManager transactionManagerArs(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryArs(builder).getObject());
    }
}
