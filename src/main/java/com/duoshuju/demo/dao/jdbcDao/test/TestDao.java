package com.duoshuju.demo.dao.jdbcDao.test;

import com.duoshuju.demo.common.config.jdbcConfig.MysqlMainJdbcBaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:25
 **/
@Repository
public class TestDao extends MysqlMainJdbcBaseDaoImpl {
	/**
	 * -测试类
	 * @return
	 */
	public String test() {
		String sql = "SELECT name from user where id = 123";
		String param = this.getJdbcTemplate().queryForObject(sql,String.class);
		System.out.println("mysql param:"+param);
		return param;
	}

}
