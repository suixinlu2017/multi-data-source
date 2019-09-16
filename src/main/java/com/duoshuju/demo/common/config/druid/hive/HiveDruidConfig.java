package com.duoshuju.demo.common.config.druid.hive;

import com.duoshuju.demo.common.config.druid.DataSourceCommonProperties;
import com.duoshuju.demo.common.config.druid.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import javax.sql.DataSource;
/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:11
 **/
/**
 * -配置hive数据源
 * @author sixmonth
 * @Date 2019年5月18日
 *
 */
@Configuration
@EnableConfigurationProperties({DataSourceProperties.class, DataSourceCommonProperties.class})//将配置类注入到bean容器，使ConfigurationProperties注解类生效
public class HiveDruidConfig {

	private static Logger logger = LoggerFactory.getLogger(HiveDruidConfig.class);

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Autowired
	private DataSourceCommonProperties dataSourceCommonProperties;

	@Bean("hiveDruidDataSource") //新建bean实例
	@Qualifier("hiveDruidDataSource")//标识
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();

		//配置数据源属性
		datasource.setUrl(dataSourceProperties.getHive().get("url"));
		datasource.setUsername(dataSourceProperties.getHive().get("username"));
		datasource.setPassword(dataSourceProperties.getHive().get("password"));
		datasource.setDriverClassName(dataSourceProperties.getHive().get("driver-class-name"));

		//配置统一属性
		datasource.setInitialSize(dataSourceCommonProperties.getInitialSize());
		datasource.setMinIdle(dataSourceCommonProperties.getMinIdle());
		datasource.setMaxActive(dataSourceCommonProperties.getMaxActive());
		datasource.setMaxWait(dataSourceCommonProperties.getMaxWait());
		datasource.setTimeBetweenEvictionRunsMillis(dataSourceCommonProperties.getTimeBetweenEvictionRunsMillis());
		datasource.setMinEvictableIdleTimeMillis(dataSourceCommonProperties.getMinEvictableIdleTimeMillis());
		datasource.setValidationQuery(dataSourceCommonProperties.getValidationQuery());
		datasource.setTestWhileIdle(dataSourceCommonProperties.isTestWhileIdle());
		datasource.setTestOnBorrow(dataSourceCommonProperties.isTestOnBorrow());
		datasource.setTestOnReturn(dataSourceCommonProperties.isTestOnReturn());
		datasource.setPoolPreparedStatements(dataSourceCommonProperties.isPoolPreparedStatements());
		try {
			datasource.setFilters(dataSourceCommonProperties.getFilters());
		} catch (SQLException e) {
			logger.error("Druid configuration initialization filter error.", e);
		}
		return datasource;
	}
}
