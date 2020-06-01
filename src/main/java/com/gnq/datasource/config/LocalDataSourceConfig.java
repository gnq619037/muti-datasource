package com.gnq.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.gnq.datasource.dao.local"}, sqlSessionTemplateRef = "localSqlSessionTemplate")
public class LocalDataSourceConfig {

    @Value("${spring.datasource.local.url}")
    private String dbUrl;

    @Value("${spring.datasource.local.username}")
    private String username;

    @Value("${spring.datasource.local.password}")
    private String password;

    @Value("${spring.datasource.local.driver-class-name}")
    private String driverClassName;

    @Bean
    /// 根据application.properteis系统配置文件中,对应属性的前缀,指明使用其对应的数据
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().url(dbUrl).driverClassName(driverClassName).password(password).username(username).build();
    }

    @Bean
    @DependsOn("localDataSource")
    public SqlSessionFactory localSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(localDataSource());
        return factoryBean.getObject();
    }

    /**
     * DefaultSqlSession和SqlSessionTemplate都实现了SqlSession,但我们
     * 注入线程安全的SqlSessionTemplate,而不使用默认的线程不安全的DefaultSqlSession
     */
    @Bean
    @DependsOn("localSqlSessionFactory")
    public SqlSessionTemplate localSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(localSqlSessionFactory());
    }

    /**
     * 事务管理器
     */
    @Bean("localTransactionManager")
    @DependsOn("localDataSource")
    public DataSourceTransactionManager localTransactionManager(@Qualifier("localDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
