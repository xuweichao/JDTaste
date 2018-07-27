package com.jdtaste.jdtasteadmin.conf;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtastesso.conf
 * @Author: xuweichao
 * @CreateTime: 2018-06-26 15:00
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.jdtaste.mybatis.mapper")
public class MybatisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return  new DataSource();
    }
}
