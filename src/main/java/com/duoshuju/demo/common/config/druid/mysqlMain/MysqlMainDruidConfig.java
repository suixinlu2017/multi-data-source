package com.duoshuju.demo.common.config.druid.mysqlMain;

import com.duoshuju.demo.common.config.druid.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.pool.DruidDataSource;
import com.duoshuju.demo.common.config.druid.DataSourceCommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;
import javax.sql.DataSource;
/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:13
 **/
/**
 * -配置mysql主数据源，mysql连接默认主数据源
 * @author sixmonth
 * @Date 2019年5月18日
 *
 */
@Configuration
@EnableConfigurationProperties({DataSourceProperties.class, DataSourceCommonProperties.class})//将配置类注入到bean容器，使ConfigurationProperties注解类生效
public class MysqlMainDruidConfig {
	private static Logger logger = LoggerFactory.getLogger(MysqlMainDruidConfig.class);

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Autowired
	private DataSourceCommonProperties dataSourceCommonProperties;

	@Primary //标明为主数据源，只能标识一个主数据源，mybatis连接默认主数据源
	@Bean("mysqlDruidDataSource") //新建bean实例
	@Qualifier("mysqlDruidDataSource")//标识
	public DataSource dataSource(){
		DruidDataSource datasource = new DruidDataSource();

		//配置数据源属性
		datasource.setUrl(dataSourceProperties.getMysqlMain().get("url"));
		datasource.setUsername(dataSourceProperties.getMysqlMain().get("username"));
		datasource.setPassword(dataSourceProperties.getMysqlMain().get("password"));
		datasource.setDriverClassName(dataSourceProperties.getMysqlMain().get("driver-class-name"));

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
