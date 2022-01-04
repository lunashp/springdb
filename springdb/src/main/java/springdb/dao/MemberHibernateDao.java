package springdb.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdb.domain.Member;

@Repository
public class MemberHibernateDao {
	//데이터베이스 연동 프레임워크 사용 인스턴스 주입
	@Autowired
	private SessionFactory sessionFactory;

	//데이터 삽입
	public void insertMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		//데이터 삽입
		session.save(member);
	}
	
	//전체 데이터 가져오는 메소드 
	public List<Member> getList(){
		//SQL 없이 수행
		/*
		CriteriaQuery <Member> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Member.class);
		criteriaQuery.from(Member.class);
		List<Member> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
		*/
		List<Member> list = sessionFactory.getCurrentSession().createSQLQuery("select*from member").addEntity(Member.class).getResultList();
		return list;
	}
	
	//기본키를 가지고 데이터1개를 찾아오는 메소드
	public Member getMember(String MEMBER_ID) {
		return (Member) sessionFactory.getCurrentSession().get(Member.class, MEMBER_ID);
	}
	//데이터 수정
	public void updateMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		//데이터 수정
		session.update(member);
	}
	//데이터 삭제
		public void deleteMember(Member member) {
			Session session = sessionFactory.getCurrentSession();
			//데이터 삭제
			session.delete(member);
}
}
