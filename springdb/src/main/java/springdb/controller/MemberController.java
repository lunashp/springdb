package springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springdb.domain.Member;
import springdb.service.MemberHibernateService;
import springdb.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberHibernateService memberHibernateService;
	//데이터 삽입 메소드
	public void insertMember() {
		/*
		boolean r = memberService.insertMember();
		if(r == true) {
			System.out.println("데이터 삽입 성공");
		}else {
			System.out.println("데이터 삽입 실패");
		}
		*/
		memberHibernateService.insertMember();
		System.out.println("데이터 삽입 성공");
	}
	
	//테이블의 전체 데이터를 출력하는 메소드
	public void getList() {
		List<Member> list =  memberHibernateService.getList();
		System.out.println(list);
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	//하나의 데이터를 조회하는 메소드
	public void getMember() {
		Member member = memberHibernateService.getMember();
		if(member == null) {
			System.out.println("조회하고자 하는 데이터가 없습니다");
		}else {
			System.out.println(member);
		}
	}
	//데이터를 수정하는 메소드
	public void updateMember() {
		memberHibernateService.updateMember();
	}
	
	//데이터를 삭제하는 메소드
	public void deleteMember() {
		 memberHibernateService.deleteMember();
		
	}
}
