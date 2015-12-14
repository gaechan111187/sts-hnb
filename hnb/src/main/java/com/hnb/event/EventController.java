package com.hnb.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieVO;


@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired
	MemberVO member;
	@Autowired
	EventServiceImpl service;
	@RequestMapping("/boardList")
	public String boardList(
			@RequestParam(value="pageNo",defaultValue="1")String pageNo,
			@RequestParam(value="column",required=false)String column,
			@RequestParam(value="searchKey",required=false)String searchKey,
			Model model){
		logger.info("EventController article() 입장");
		List<MovieVO> list = service.getList(CommandFactory.list(pageNo));
		int count = service.count();
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("count", count);
		model.addAttribute("memberList", list);
		return "event/boardList.jsp";
	}
}
