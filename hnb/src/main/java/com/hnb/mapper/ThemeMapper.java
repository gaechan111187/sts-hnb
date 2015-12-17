package com.hnb.mapper;

import java.util.List;

import com.hnb.global.Command;
import com.hnb.theme.ThemeVO;

public interface ThemeMapper {
	// C : 추가
				public int addBoard(ThemeVO theme); //게시판목록 추가
				
				// R : 조회
				public List<ThemeVO> getList(Command command); //전체게시판목록
				public List<ThemeVO> searchByKeyword(Command command); //임의의 값으로 검색
				public ThemeVO searchByNumber(int rcdNo); //게시판 번호로 조회
				public int count(); //전체 게시판 수 조회
				public int countByKeyword(Command command); // 검색결과의 갯수만 조회
				// U : 정보 변경
				public int changeBoard(ThemeVO theme); //게시판 이름변경
				
				// D : 삭제 
				public int removeBoard(int rcdNo);	//게시판 삭제
}
