package com.hnb.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.MemberMapper;
import com.hnb.movie.MovieServiceImpl;

@Service
public class MemberServiceImpl  implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	// 회원가입
	@Override
	public int join(MemberVO member) {
		logger.info("memberServiceImpl : join");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}
	
	// 전체 회원목록 조회
	@Override
	public List<MemberVO> getList(Command command) {
		logger.info("memberServiceImpl : join");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectAll(command);
	}
	
	// 임의의 검색어로 조회
	@Override
	public List<MemberVO> searchByKeyword(String column, String keyword) {
		logger.info("memberServiceImpl : join");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectSomeBy(column, keyword);
	}
	
	// ID로 회원검색
	@Override
	public MemberVO selectById(String id) {
		logger.info("memberServiceImpl : join");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectOneBy(id);
	}
	
	// 총 회원 수 검색
	@Override
	public int count() {
		logger.info("memberServiceImpl : count");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}
	
	// 로그인
	@Override
	public MemberVO login(String id, String pass) {
		logger.info("memberServiceImpl : login");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO loginMember =null;
		loginMember = mapper.selectOneBy(id);
		if (loginMember.getId() == null) {
			return null;
		} 
		if (loginMember.getPassword().equals(pass)) {
			return loginMember;
		}else{
			return null;
		}
	}
	
	// 회원정보 변경
	@Override
	public int change(MemberVO member) {
		logger.info("memberServiceImpl : change");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.update(member);
	}
	
	// 회원탈퇴
	@Override
	public int remove(String id) {
		logger.info("memberServiceImpl : remove");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.delete(id);
	}
}
