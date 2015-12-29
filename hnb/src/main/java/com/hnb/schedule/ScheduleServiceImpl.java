package com.hnb.schedule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.mapper.ScheduleMapper;
@Service
public class ScheduleServiceImpl implements ScheduleService{
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	@Override
	public List<String> getRateList() {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getRateList();
	}
	@Override
	public List<String> getAscList() {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getAscList();
	}
	@Override
	public List<String> getTheaterList() {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterList();
	}
	@Override
	public List<String> getShowDateList() {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateList();
	}
	@Override
	public List<String> getTheaterListByM(String movie) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByM(movie);
	}
	@Override
	public List<String> getShowDateListByM(String movie) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByM(movie);
	}
	@Override
	public List<?> getTheaterListByMD(String movie, String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByMD(movie, date);
	}
	@Override
	public List<?> getShowDateListByMT(String movie, String theater) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByMT(movie, theater);
	}
	@Override
	public List<?> getMovieRateByTD(String theater, String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByTD(theater, date);
	}
	@Override
	public List<?> getMovieAscByTD(String theater, String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByTD(theater, date);
	}
	@Override
	public List<?> getMovieRateByT(String theater) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByT(theater);
	}
	@Override
	public List<?> getMovieAscByT(String theater) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByT(theater);
	}
	@Override
	public List<?> getShowDateListByT(String theater) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getShowDateListByT(theater);
	}
	@Override
	public List<?> getMovieRateByD(String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieRateByD(date);
	}
	@Override
	public List<?> getMovieAscByD(String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getMovieAscByD(date);
	}
	@Override
	public List<?> getTheaterListByD(String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTheaterListByD(date);
	}
	@Override
	public List<?> getTimeList(String movie, String theater, String date) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getTimeList(movie,theater,date);
	}
	@Override
	public String getFilmNumberBy(String movie) {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getFilmNumberBy(movie);
	}
}
