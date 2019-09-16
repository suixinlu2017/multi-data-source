package com.duoshuju.demo.common.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:21
 **/
@Data
@ConfigurationProperties(prefix = DataSourceProperties.DS, ignoreUnknownFields = false)
public class DataSourceProperties {
	final static String DS = "spring.datasource";

	private Map<String, String> mysqlMain;

	private Map<String, String> hive;

	private Map<String, String> commonconfig;
}

