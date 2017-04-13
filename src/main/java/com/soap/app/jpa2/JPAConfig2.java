package com.soap.app.jpa2;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.soap.app.repository2",
    entityManagerFactoryRef = "datasource2EntityManager",
    transactionManagerRef = "datasource2TransactionManager")
public class JPAConfig2 {

  private static final Logger logger = LoggerFactory.getLogger(JPAConfig2.class);

  @Autowired
  private Environment env;

  @Bean
  public LocalContainerEntityManagerFactoryBean datasource2EntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource2());
    em.setPackagesToScan(new String[] {"com.soap.app.model2"});
    em.setBeanName("datasource2EntityManager");
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
    properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    em.setJpaPropertyMap(properties);
    logger.info("datasource2EntityManager init complete.");
    return em;
  }

  @Bean
  @ConfigurationProperties(prefix="spring.datasource2")
  public DataSource dataSource2() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public PlatformTransactionManager datasource2TransactionManager() {
    return new JpaTransactionManager(datasource2EntityManager().getObject());
  }
}
