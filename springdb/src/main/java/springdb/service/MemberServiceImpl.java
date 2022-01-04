package springdb.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdb.dao.MemberDao;
import springdb.dao.MemberMapper;
import springdb.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
//	private MemberDao memberDao;
	private MemberMapper memberDao;

	@Override
	public boolean insertMember() {
		boolean result = false;

		//파라미터를 읽고 DAO의 파라미터를 생성
		Member member = new Member();
		member.setMEMBER_ID("kdh2");
	      member.setMEMBER_PW("1234");
	      member.setMEMBER_NAME("김동현");
	      member.setMEMBER_EMAIL("kdh12@naver.com");
	      member.setMEMBER_PHONE("01064858877");
	      member.setMEMBER_NICKNAME("동현");
	      member.setMEMBER_GENDER("남");
	      member.setMEMBER_ADDRESS("서울시 마포구 염리동");
	      member.setMEMBER_IP("192.168.10.111");
	      Calendar cal = new GregorianCalendar();
	      member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
	      member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));

		//Dao의 메소드 호출
		int r = memberDao.insertMember(member);
		if(r>0) {
			result = true;
		}

		return result;
	}

	@Override
	public List<Member> getList() {
		return memberDao.getlist();
	}

	@Override
	public Member getMember() {
		return memberDao.getMember("yhj882");		
	}

	@Override
	public boolean updateMember() {
		Member member = new Member();
		
		boolean result = false;
		member.setMEMBER_ID("yhj882");
	      member.setMEMBER_PW("0404");
	      member.setMEMBER_NAME("이혁재");
	      member.setMEMBER_EMAIL("dal44@naver.com");
	      member.setMEMBER_PHONE("01044444444");
	      member.setMEMBER_NICKNAME("혁재");
	      member.setMEMBER_GENDER("남");
	      member.setMEMBER_ADDRESS("경기도 용인시");
	      member.setMEMBER_IP("192.168.10.101");
	      Calendar cal = new GregorianCalendar();
	      member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
	      member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));
	      
	      int r = memberDao.updateMember(member);
	      
	      if(r>=0) {
	    	  result = true;
	      }
	      return result;
	}
	@Override
	public boolean deleteMember() {
		boolean result = false;
		
		int r = memberDao.deleteMember("kdh2");
		if(r>=0) {
			result = true;
		}
		
		return result;
	}

}

