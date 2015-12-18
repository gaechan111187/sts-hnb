package com.hnb.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.article.ArticleServiceImpl;
import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;


@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired MemberVO member;
	@Autowired MemberServiceImpl memberService;

	@RequestMapping("/memberSearch/{pageNo}")
	public String memberSearch(
			@PathVariable("pageNo")String pageNo,
			@RequestParam("keyword")String keyword,
			@RequestParam("column")String column, Model model
			){
		logger.info("EventController article()");
		logger.info("넘어온 페이지번호 : {}",pageNo);
		logger.info("넘어온 컬럼 : {}",column);
		logger.info("넘어온 검색어 : {}",keyword);
		Command command = CommandFactory.search(column, keyword, pageNo);
		List<MemberVO> list = memberService.searchByKeyword(command);
		int count = memberService.countByKeyword(command);
		logger.info("리스트 결과 : {}",list.size());
		model.addAttribute("memberList",list);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("count", count);
		return "event/boardSearch.tiles";
	}
}
