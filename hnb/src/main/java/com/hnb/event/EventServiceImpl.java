package com.hnb.event;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.EventMapper;
import com.hnb.mapper.MemberMapper;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieVO;

@Service
public class EventServiceImpl implements EventService{
	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	public List<MovieVO> getList(Command command) {
		logger.info("MovieServiceImpl : getList()");
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		List<MovieVO> list =mapper.selectAll(command);
		logger.info("Mybatis 리턴값 : {}", list);
		return mapper.selectAll(command);
	}
	public int count(){
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		int count =mapper.count();
		return count;
	}
	public List<MemberVO> searchByKeyword(Command command) {
		logger.info("memberServiceImpl : join");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectSomeBy(command);
	}
	public int countByKeyword(Command command) {
		logger.info("memberServiceImpl : countByKeyword");
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.countByKeyword(command);
	}
}
