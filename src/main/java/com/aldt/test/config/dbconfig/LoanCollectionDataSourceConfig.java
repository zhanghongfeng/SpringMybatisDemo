package com.aldt.test.config.dbconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by zhf2015 on 2020-10-23.
 */

@Configuration
@MapperScan(basePackages = {"com.aldt.test.dao.mapper.loanCollection"} , sqlSessionFactoryRef = "loanCollectionSqlSessionFactory")
@PropertySource("classpath:dbconfig/db.properties")
public class LoanCollectionDataSourceConfig {

    @Value("${aldt.test.datasource.loan-collection.jdbc-url}")
    private String jdbcUrl;

    @Value("${aldt.test.datasource.loan-collection.username}")
    private String username;

    @Value("${aldt.test.datasource.loan-collection.password}")
    private String password;

    @Value("${aldt.test.datasource.loan-collection.driver-class-name}")
    private String driverClassName;


    @Bean(name = {"loanCollectionDataSource"})
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return hikariDataSource;
    }

    @Bean(name = "loanCollectionTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean(name = "loanCollectionSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("loanCollectionDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/loanCollection/**/*Mapper.xml"));
        return sessionFactory.getObject();
    }
}
