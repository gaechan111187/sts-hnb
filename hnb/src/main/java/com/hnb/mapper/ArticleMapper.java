package com.hnb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
@Repository
public interface ArticleMapper {
	// C : 추가(회원가입)
	public int write(ArticleVO article);
	
	// R : 조회
	public List<ArticleVO> getList(Command command); //전체회원목록
	public List<ArticleVO> searchByKeyword(Command command); //임의의 값으로 검색
	public ArticleVO searchById(int rcdNo); //글번호로 조회
	public int count(); //전체회원수 조회
	public int countByKeyword(Command command); // 검색결과의 갯수만 조회
	// U : 정보 변경
	public int change(ArticleVO article);
	
	// D : 삭제 
	public int remove(int rcdNo);
}
