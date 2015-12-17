package com.hnb.theme;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ThemeMapper;

@Service
public class ThemeServiceImpl implements ThemeService{
	private static final Logger logger = LoggerFactory.getLogger(ThemeServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	@Override
	public int addBoard(ThemeVO theme) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.addBoard(theme);
	}

	@Override
	public List<ThemeVO> getList(Command command) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.getList(command);
	}

	@Override
	public List<ThemeVO> searchByKeyword(Command command) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.searchByKeyword(command);
	}

	@Override
	public ThemeVO searchByNumber(int rcdNo) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.searchByNumber(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int changeBoard(ThemeVO theme) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.changeBoard(theme);
	}

	@Override
	public int removeBoard(int rcdNo) {
		logger.info("ThemeServiceImpl : addBoard");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.removeBoard(rcdNo);
	}
	
}
