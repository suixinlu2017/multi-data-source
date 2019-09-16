package com.duoshuju.demo.dao.jdbcDao.test;

import com.duoshuju.demo.common.config.jdbcConfig.HiveJdbcBaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:26
 **/
@Repository
public class TestHiveDao extends HiveJdbcBaseDaoImpl {
	/**
	 * 测试获取hive数据库数据信息
	 * @return
	 */
	public String test() {
		String sql = "SELECT username from tb_user limit 1";
		String param = this.getJdbcTemplate().queryForObject(sql,String.class);
		System.out.println("hive param:"+param);
		return param;
	}

}
