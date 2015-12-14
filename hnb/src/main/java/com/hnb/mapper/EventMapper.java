package com.hnb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnb.global.Command;
import com.hnb.movie.MovieVO;
@Repository
public interface EventMapper {

	List<MovieVO> selectAll(Command command);
	public int count(); //전체회원수 조회
}
