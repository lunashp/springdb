package springdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import springdb.domain.Member;

@Repository
public interface MemberMapper {
	//전체 데이터 가져오기
	@Select("select * from member")
	public List<Member> getlist();
	
	//데이터 1개 가져오기
	@Select("select from member where MEMBER_ID = #{MEMBER_ID}")
	public Member getMember(String MEMBER_ID);
	
	@Insert("insert into member\r\n"
			+ "		VALUES (#{MEMBER_ID}, #{MEMBER_PW}, #{MEMBER_NAME}, #{MEMBER_EMAIL}, #{MEMBER_PHONE}, #{MEMBER_NICKNAME}, #{MEMBER_GENDER}, #{MEMBER_ADDRESS}, #{MEMBER_IP}, #{MEMBER_LOGINDATE}, #{MEMBER_JOINDATE})")
	public int insertMember(Member member);
	
	@Update("update member\r\n"
			+ "	set  MEMBER_PW=#{MEMBER_PW}, MEMBER_NAME=#{MEMBER_NAME}, MEMBER_EMAIL=#{MEMBER_EMAIL}, MEMBER_PHONE=#{MEMBER_PHONE}, MEMBER_NICKNAME=#{MEMBER_NICKNAME}, MEMBER_GENDER=#{MEMBER_GENDER}, MEMBER_ADDRESS=#{MEMBER_ADDRESS}, MEMBER_IP=#{MEMBER_IP}, MEMBER_LOGINDATE=#{MEMBER_LOGINDATE}, MEMBER_JOINDATE=#{MEMBER_JOINDATE}\r\n"
			+ "	where MEMBER_ID = #{MEMBER_ID}")
	public int updateMember(Member member);

	@Delete("delete from member\r\n"
			+ "	where MEMBER_ID = #{MEMBER_ID}")
	public int deleteMember(String member);
	
}
