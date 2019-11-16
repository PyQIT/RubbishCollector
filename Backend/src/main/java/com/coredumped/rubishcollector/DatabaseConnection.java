package com.coredumped.rubishcollector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConnection {

    @Value("org.h2.Driver")
    private String DriverClassName;
    @Value("jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE;;INIT=CREATE SCHEMA IF NOT EXISTS TEST_SCHEMA;DB_CLOSE_DELAY=-1")
    private String url;
    @Value("sa")
    private String userName;
    @Value("")
    private String password;
    @Value("com.coredumped.rubishcollector.api.model")
    private String packages;
    @Value("hibernate.hm2ddl.show_sql")
    private String showSql;
    @Value("hibernate.hbm2ddl.auto")
    private String crud;
    @Value("hibernate.dialect")
    private String dialect;
    @Value("org.hibernate.dialect.H2Dialect")
    private String h2dialect;
    @Value("true")
    private String showSqlDecision;
    @Value("update")
    private String crudDecision;


    @Bean
    @PostConstruct
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DriverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(packages);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(crud, crudDecision);
        properties.setProperty(showSql, showSqlDecision);
        properties.setProperty(dialect, h2dialect);

        return properties;
    }

}