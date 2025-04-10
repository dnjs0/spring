package src.test.java.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//JUnit4를 Spring 환경에서 실행 가능하게 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPTESTs {
	@Autowired
	private DataSource dataSource;
	
	@Ignore
	@Test
	public void testJDBC() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","spring","java1234");
			
			assertNotNull(conn);
			assertFalse(conn.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	@Test
	public void testCommonsDBCP() {
		
//		DataSource dataSource;
		assertNotNull(dataSource);
		
		try {
		
			Connection conn = dataSource.getConnection();
			assertFalse(conn.isClosed());
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}

















