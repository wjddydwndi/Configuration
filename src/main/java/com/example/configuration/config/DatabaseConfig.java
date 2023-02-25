package com.example.configuration.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.database.url}")
    private String url;
    @Value("${spring.database.username}")
    private String username;
    @Value("${spring.database.password}")
    private String password;
    @Value("${spring.database.driver-class-name}")
    private String driverClassName;
    @Value("${spring.database.hikari.pool-size}")
    private int poolSize;
    @Value("${spring.database.hikari.enckey}")
    private String enckey;
    @Value("${spring.database.hikari.idle-timeout}")
    private int idleTimeout;
    @Value("${spring.database.hikari.max-life-time}")
    private int maxLifeTime;
    @Value("${spring.database.hikari.leak-detection-threshold}")
    private int leakDetectionThreshold;
    @Value("${spring.database.hikari.validation-timeout}")
    private int validationTimeout;


    @Bean(name="dataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driverClassName);
        // options
        hikariConfig.setIdleTimeout(idleTimeout);                                   //  connection pool 에 일을 안하는 connection이 유지하는 시간
        hikariConfig.setMaxLifetime(maxLifeTime);                                   //  connection pool 에서 살아있을 수 있는 connection 의 최대 수명 시간
        hikariConfig.setLeakDetectionThreshold(leakDetectionThreshold);             //  connection 이 누수 로그 메시지가 나오기 전에 connection 을 검사하여 pool에서 connection 을 내보낼 수 있는 시간; 0으로 설정시 사용하지 않음.
        hikariConfig.setValidationTimeout(validationTimeout);                       //  valid query 를 통해 connection 이 유효한지 검사할 때 사용되는 timeout *default:5000 ms
        hikariConfig.setMaximumPoolSize(poolSize);                                  //  connection pool에 유지시킬 수 있는 최대 connection 수 *default 10
        hikariConfig.setAutoCommit(true);                                           //  connection 이 종료되거나 pool에 반환된 때, connection에 속해잇는 transaction을 commit 할지를 결정
        hikariConfig.setConnectionTimeout(3000);                                    //  connection pool 에서 connection 을 얻어오기 전까지 기다리는 최대시간, 허용가능한 wait time을 초과하면 SQL Exception 발생 *default 30000 ms (30s)
        hikariConfig.setPoolName("database-database-pool");                      //  connection pool 이름을 지정함. logging 이나 JMX management console 에 표시되는 이름
        hikariConfig.setConnectionInitSql("SET @enckey = '".concat(enckey).concat("'"));
        hikariConfig.setConnectionTestQuery("SELECT 1");

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        return hikariDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier ("dataSource")DataSource dataSource, ApplicationContext applicationContext) throws Exception{

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResource("classpath:mybatis/mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
