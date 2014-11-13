package com.som.blog.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * @author som
 */
@Configuration
@EnableJpaRepositories(basePackages ="com.som.blog.repository")
public class ApplicationConfig {

//    @Bean
//    public DataSource dataSource(){
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//    }
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test_db");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("pizdec");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setDefaultAutoCommit(false);
        return dataSource;

//        class="org.apache.commons.dbcp.BasicDataSource">
//        <property name="driverClassName" value="org.postgresql.Driver"/>
//        <property name="url" value="jdbc:postgresql://localhost:5432/blog"/>
//        <property name="username" value="test_db"/>
//        <property name="password" value="pizdec"/>
//        <property name="initialSize" value="5"/>
//        <property name="maxActive" value="10"/>
    }


    /**
     * Sets up a {@link org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean} to use Hibernate. Activates picking up entities from the
     * project's base package.
     *
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setPackagesToScan("com.som.blog.repository", "com.som.blog.domain");
//        factory.setPackagesToScan("com.som.blog.domain");
        factory.setDataSource(dataSource());

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }


    /**
     * Loading Spring configs and creating context
     *
     * @return Spring application context
     */
//    public static GenericApplicationContext getApplicationContext() {
//        GenericXmlApplicationContext springAppContext = new GenericXmlApplicationContext();
//        //TODO: move from code to configs. Read from properties
//        springAppContext.load("classpath*:/com/som/blog/*-config.xml",
//                "classpath*:/com/som/blog/service/*-config.xml",
//                "classpath*:/com/som/blog/repository/*-config.xml",
//                "classpath*:com/som/blog/datasource/*-config.xml");
//        springAppContext.refresh();
//        return springAppContext;
//    }

}
