package springdb;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdb.controller.MemberController;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		MemberController memberController = context.getBean("memberController", MemberController.class);
		//memberController.insertMember();
		
		//memberController.getList();
		
		//memberController.getMember();
		
		//memberController.updateMember();
		
		memberController.deleteMember();

		context.close();

	}

}

