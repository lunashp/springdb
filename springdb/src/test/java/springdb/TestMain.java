package springdb;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdb.controller.MemberController;

public class TestMain {
	@Test
	public void connectionTest() throws Exception{
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		DataSource ds = context.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		//연결까지 확인
		Connection con = ds.getConnection();
		System.out.println(con);
		
		SqlSession session = context.getBean("sqlSession", SqlSession.class);
		System.out.println(session);
		
		MemberController memberController = context.getBean("memberController", MemberController.class);
		System.out.println(memberController);
		
		con.close();
		
		context.close();
	}

}
