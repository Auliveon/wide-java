package com.widejava.configuration.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@SuppressWarnings("SpellCheckingInspection")
@EnableTransactionManagement
public class WideJavaHibernateConfig {

    @Value("${wide-java.datasource.name}")
    private String dataSourceName;

    @Value("${wide-java.datasource.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${wide-java.datasource.hibernate.schema.what:none}")
    private String hibernateSchemaWhat;

    @Value("${wide-java.datasource.hibernate.sql.show:false}")
    private boolean hibernateShowSql;

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.widejava");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean({ "mainDataSource" })
    public DataSource mainDataSource() {
        return new JndiDataSourceLookup().getDataSource(dataSourceName);
    }

    private Properties hibernateProperties() {
        return new Properties() {
            private static final long serialVersionUID = 1L;

            {
                setProperty("use_outer_join", "false");
                setProperty("hibernate.jdbc.use_streams_for_binary", "true");
                setProperty("hibernate.jdbc.batch_size", "20");
                setProperty("hibernate.max_fetch_depth", "2");
                setProperty("hibernate.dialect", hibernateDialect);
                setProperty("hibernate.hbm2ddl.auto", hibernateSchemaWhat);
                if (hibernateShowSql) {
                    setProperty("hibernate.show_sql", "true");
                    setProperty("hibernate.format_sql", "true");
                    setProperty("hibernate.use_sql_comments", "true");
                    setProperty("hibernate.generate_statistics", "true");
                }

            }
        };
    }

}
