package com.siang.springboot.practice.springbootpractice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Profile("devMySQL")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "myJdbcEntityManagerFactory",
        transactionManagerRef = "myJdbcTransactionManager",
        basePackages = "com.siang.springboot.practice.springbootpractice.database.myjdbc.repository")
@Configuration
public class MyJdbcDataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.myjdbc")
    public DataSource myjdbcDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("myJdbcTemplate")
    public NamedParameterJdbcTemplate myJdbcTemplate(
            @Qualifier("myjdbcDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean myJdbcEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("myjdbcDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.siang.springboot.practice.springbootpractice.database.myjdbc.entity")
                .persistenceUnit("myJdbc").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager myJdbcTransactionManager(
            @Qualifier("myJdbcEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
