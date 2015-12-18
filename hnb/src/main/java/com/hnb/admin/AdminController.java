package com.hnb.admin;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieServiceImpl;
import com.hnb.movie.MovieVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberServiceImpl memberService;
	@Autowired MovieServiceImpl movieService;
	@Autowired MemberVO member;
	@Autowired MovieVO movie;
	@RequestMapping("/main")
	public String home(){
		logger.info("AdminController-home() 진입");
		return "admin/admin/main.tiles";
	}
	@RequestMapping("/movie_list")
	public String movieList(){
		logger.info("movieList() 진입");
		List<MovieVO> movie_list;
		
		return "admin/movie_list";
	}
	@RequestMapping("/member_list/{pageNo}")
	public @ResponseBody Map<String, Object> memberList(
			@PathVariable("pageNo")String pageNo,
			Model model){
		logger.info("AdminController article()");
		logger.info("넘어온 페이지번호 : {}",pageNo);
		int pageSize = 5, groupSize = 3, count = memberService.count(), totPage = 0, startPage=0,lastPage = 0;
		int pageNum = Integer.parseInt(pageNo);
		totPage = ((count % pageSize) == 0) ? count/pageSize : (count/pageSize)+1;
		startPage = pageNum - ((pageNum-1)%groupSize);
		lastPage = ((startPage+groupSize-1) <= totPage) ? (startPage+groupSize)-1 : totPage;
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("list", memberService.getList(CommandFactory.list(pageNo)));
		map.put("count", count);
		map.put("pageNo",pageNo);
		map.put("startPage", startPage);
		map.put("groupSize", groupSize);
		map.put("lastPage", lastPage);
		map.put("totPage", totPage);
		return map;
	}
	@RequestMapping("/member_profile")
	public String memberProfile(){
		logger.info("memberProfile() 진입");
		return "admin/member_profile";
	}
	@RequestMapping("/movie_profile")
	public String movieProfile(){
		logger.info("movieProfile() 진입");
		return "admin/movie_profile";
	}
	@RequestMapping("/insert")
	public String insert(){
		logger.info("insert() 진입");
		return "admin/insert";
	}
	@RequestMapping("/insert2")
	public String insert2(){
		logger.info("insert2() 진입");
		return "admin/insert2";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("delete() 진입");
		return "admin/delete";
	}
}
