package com.duoshuju.demo.controller;

import com.duoshuju.demo.dao.jdbcDao.test.TestDao;
import com.duoshuju.demo.dao.jdbcDao.test.TestHiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: demo
 * @description:
 * @author: chenyulong
 * @create: 2019-09-16 10:28
 **/
@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestDao testDao;

	@Autowired
	private TestHiveDao testHiveDao;

	@ResponseBody
	@RequestMapping("mysql")
	private void testMysql(){
		testDao.test();
	}
	@ResponseBody
	@RequestMapping("hive")
	private void testHive(){
		testHiveDao.test();
	}
}
