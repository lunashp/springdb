package springdb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdb.domain.Member;

//@Repository
public class MemberDao {

	@Autowired
	//XML을 이용하는 MyBatis 사용 객체
	private SqlSession sqlSession;


	//데이터 삽입을 위한 메소드
	public int insertMember(Member member) {
		//member namespace의 insertmember 라는 id 를 가진 sql을 실행하는데
		//파라미터로 member를 대입 
		return sqlSession.insert("member.insertmember", member);


	}
	public List<Member> getList() {
		//데이터가 1개도 없으면 size가 0
		return sqlSession.selectList("member.getlist");
	}
	public Member getMember(String MEMBER_ID) {
		//조회되는 데이터가 없거나 1개인 경우 사용
		//데이터가 없으면 null을 리턴하고 1개인 경우는 resultType 1개리턴
		//2개 이상이면 예외 발생 
		return sqlSession.selectOne("member.getmember", MEMBER_ID);
	}
	public int updateMember(Member member) {
		return sqlSession.update("member.updatemember", member);
	}
	public int deleteMember(String MEMBER_ID) {
		return sqlSession.delete("member.deletemember", MEMBER_ID);
	}
}
