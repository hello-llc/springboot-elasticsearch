package com.cun.util.es.datasource;


import org.apache.ibatis.plugin.Interceptor;
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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*
 * @Primary:意思是在众多相同的bean中，优先使用用@Primary注解的bean
 * @Qualifire:让Spring可以按照Bean名称进入注入@Autowired
 */

@Configuration//注册到springboot容器
@MapperScan(basePackages = {"com.cun.util.es.db.mapper"}, sqlSessionFactoryRef = "dataSqlSessionFactory")
public class DataSourceEsConfig {

    // 加载全局的配置文件
    @Value("${mybatis.config-location}")
    private String configLocation;

    @Bean(name = "dataDataSource")//注入到这个容器
    @ConfigurationProperties(prefix = "spring.datasource.data")//表示取application.properties配置文件中的前缀
    @Primary
    public DataSource dataDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSqlSessionFactory")
    @Primary
    public SqlSessionFactory dataSqlSessionFactory(@Qualifier("dataDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        // 设置mybatis-config.xml配置文件位置
        sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));

        // 添加分页插件、打印sql插件
        Interceptor[] plugins = new Interceptor[]{};
        sessionFactoryBean.setPlugins(plugins);

        return sessionFactoryBean.getObject();
    }

    @Bean(name = "dataTransactionManager")//配置事务
    @Primary
    public DataSourceTransactionManager dataTransactionManager(@Qualifier("dataDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dataSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate dataSqlSessionTemplate(@Qualifier("dataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public JdbcTemplate dataTemplate(@Qualifier("dataDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate dataParameterTemplate(@Qualifier("dataDataSource") DataSource primaryDataSource) {
        return new NamedParameterJdbcTemplate(primaryDataSource);
    }
}
