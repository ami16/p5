package edu.cursor.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import java.util.Properties;


@Configuration
@ComponentScan
@PropertySource(value = "classpath:app-db.properties")
@EnableJpaRepositories("edu.cursor.dao")
@Import({WebSecurityConfig.class})
public class AppConfig {


   @Value("${db.connection.url}")
   private String dbConnectionUrl;

   @Value("${db.user.name}")
   private String dbUserName;

   @Value("${db.user.pass}")
   private String dbUserPass;

   @Value("${jdbc.driver.className}")
   private String driverClassName;

   @Value("${db.hibernate.show_sql}")
   private String PROP_HIBERNATE_SHOW_SQL;

   @Value("${db.hibernate.dialect}")
   private String PROP_HIBERNATE_DIALECT;

   @Value("${db.hibernate.hbm2ddl.auto}")
   private String PROP_HIBERNATE_HBM2DDL_AUTO;


   @Bean
   public DriverManagerDataSource dataSource(){

      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(driverClassName);
      dataSource.setUrl(dbConnectionUrl);
      dataSource.setUsername(dbUserName);
      dataSource.setPassword(dbUserPass);

      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

      LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
      emFactory.setDataSource(dataSource());
      emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      emFactory.setJpaVendorAdapter( new HibernateJpaVendorAdapter());
//      emFactory.setPackagesToScan("edu.cursor.dao", "edu.cursor.model");
      emFactory.setPackagesToScan("edu.cursor.model");

      emFactory.setJpaProperties(getHibernateProperties());
      return emFactory;
   }

   private Properties getHibernateProperties() {
      Properties properties = new Properties();
      properties.put(PROP_HIBERNATE_DIALECT, PROP_HIBERNATE_DIALECT);
      properties.put(PROP_HIBERNATE_SHOW_SQL, PROP_HIBERNATE_SHOW_SQL);
      properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, PROP_HIBERNATE_HBM2DDL_AUTO);
      return properties;
   }

   @Bean
   public JpaTransactionManager transactionManager(){
      JpaTransactionManager tm = new JpaTransactionManager();
      tm.setEntityManagerFactory(entityManagerFactory().getObject());
      return tm;
   }

   @Bean
   public CacheManager cacheManager() {
      return new ConcurrentMapCacheManager();
   }
}