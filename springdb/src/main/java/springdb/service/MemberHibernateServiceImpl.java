package springdb.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdb.dao.MemberHibernateDao;
import springdb.domain.Member;

@Service
public class MemberHibernateServiceImpl implements MemberHibernateService{

	@Autowired 
	private MemberHibernateDao memberHibernateDao;

	@Override
	//트랜잭션을 적용
	@Transactional
	public void insertMember() {
		Member member = new Member();
		member.setMEMBER_ID("dh");
		member.setMEMBER_PW("1025");
		member.setMEMBER_NAME("이동해");
		member.setMEMBER_EMAIL("ldh1025@naver.com");
		member.setMEMBER_PHONE("01012345678");
		member.setMEMBER_NICKNAME("동해");
		member.setMEMBER_GENDER("남");
		member.setMEMBER_ADDRESS("서울특별시 성동구");
		member.setMEMBER_IP("192.168.10.100");

		Calendar cal = new GregorianCalendar();
		member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
		member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));

		memberHibernateDao.insertMember(member);
	}

	@Override
	@Transactional
	public List<Member> getList() {
		return memberHibernateDao.getList();
	}

	@Override
	@Transactional
	public Member getMember() {
		return memberHibernateDao.getMember("dh");
	}

	@Override
	@Transactional
	public void updateMember() {
		Member member = new Member();
		member.setMEMBER_ID("yhj882");
		member.setMEMBER_PW("0404");
		member.setMEMBER_NAME("이혁재");
		member.setMEMBER_EMAIL("lhj0404@naver.com");
		member.setMEMBER_PHONE("01044444444");
		member.setMEMBER_NICKNAME("은혁");
		member.setMEMBER_GENDER("남");
		member.setMEMBER_ADDRESS("경기도 용인시");
		member.setMEMBER_IP("192.168.10.102");

		Calendar cal = new GregorianCalendar();
		member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
		member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));
		
		memberHibernateDao.updateMember(member);
	}

	@Override
	@Transactional
	public void deleteMember() {
		Member member = new Member();
		member.setMEMBER_ID("yhj8821");

		memberHibernateDao.deleteMember(member);

	}

}
