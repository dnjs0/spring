package com.test.mybatis.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class HikariCPTests {

	//필드주입(4는 지원안해서)
		@Autowired
		private DataSource dataSource; //HikariDataSource
		
		//생성자 주입
		//생성자가 하나일땐 어노테이션 안붙여도 되지만 분명하게 하도록 붙임
		//@Autowired 
		//public CommonsDBCPTests(DataSource dataSource) {
		//	this.dataSource = dataSource;
		//}
		
		
		
		@Test
		public void testGetDataConnection() {
			
			assertNotNull(dataSource);
			
		}

		@Test
		public void testGetConnection(){
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotNull(conn);
		}
		
		
		@Test
		public void testIsConnected() {
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
				assertFalse(conn.isClosed());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
