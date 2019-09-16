package com.duoshuju.demo.common.config.jdbcConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:23
 **/

@Repository
public class HiveJdbcBaseDaoImpl {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(@Qualifier("hiveDruidDataSource") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
