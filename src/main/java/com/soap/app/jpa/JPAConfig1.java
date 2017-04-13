package com.soap.app.jpa;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.soap.app.repository",
    entityManagerFactoryRef = "datasource1EntityManager",
    transactionManagerRef = "datasource1TransactionManager")
public class JPAConfig1 {

  private static final Logger logger = LoggerFactory.getLogger(JPAConfig1.class);
  @Autowired
  private Environment env;

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean datasource1EntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource1());
    em.setPackagesToScan(new String[] {"com.soap.app.model"});
    em.setBeanName("datasource1EntityManager");
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
    properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    em.setJpaPropertyMap(properties);
    logger.info("datasource1EntityManager init complete.");
    return em;
  }

  @Primary
  @Bean
  @ConfigurationProperties(prefix="spring.datasource")
  public DataSource dataSource1() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean
  public PlatformTransactionManager datasource1TransactionManager() {
    return new JpaTransactionManager(datasource1EntityManager().getObject());
  }
}
