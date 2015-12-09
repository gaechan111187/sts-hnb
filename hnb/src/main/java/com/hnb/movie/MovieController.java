package com.hnb.movie;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;
	
		@RequestMapping("/Movie")
		public String movie(){
			logger.info("MovieController : movie()진입");
			return "movie/Movie.tiles";
		}
		@RequestMapping("/movie_info")
		public Model movieInfo(Model model){
			logger.info("MovieController : movieInfo()진입");
			List<MovieVO> list = service.getList();
			model.addAttribute("movieList", list);
			logger.info("영화리스트 조회결과{}", list);
			return model;
		}
		@RequestMapping("/movie_name/{movieName}")
		public @ResponseBody MovieVO movieName(
				@PathVariable("name")String name){
			logger.info("MovieController : movieName()진입");
			logger.info("영화 아이디 : {}", name);
			movie = service.searchByName(name);
			logger.info("영화제목 : {}", movie.getFilmName());
			return movie;
		}
		@RequestMapping("/movie_Cut")
		public Model movieCut(	String filmNumber,Model model){
			logger.info("MovieController : movieCut()진입");
			logger.info("MovieCut의 filmNumber : {}", filmNumber);
			movie = service.searchByName(filmNumber);
			String[]arr = movie.getCut().split("/");
				logger.info("arr : {}", arr);
			model.addAttribute("arr", arr);
			return model;
		}
		@RequestMapping("/movie_Tra")
		public Model movieTra(String filmNumber,Model model){
			logger.info("MovieController : movieTra()진입");
			logger.info("MovieTra의 filmnumber :  {}",filmNumber);
			movie = service.searchByName(filmNumber);
			String tra = movie.getTrailer();
			logger.info("movie_tra의 getTrailer : {}", tra);
			String[]arrt = tra.split("/");
			logger.info("트레일러 : {}", arrt);
			model.addAttribute("arrt", arrt);
			
			return model;
		}
		@RequestMapping("/movie_Basic")
		public @ResponseBody MovieVO movieBasic(String filmNumber,	Model model){ 
			logger.info("MovieController : movieBasic()진입");
			logger.info("movieBasic의 filmNumber : {}", filmNumber);
			movie = service.searchByName(filmNumber);
			logger.info("movieBasic의 filmName : {}", movie.getFilmName());
			return movie;
		}
		@RequestMapping("/movie_Chart")
		@ModelAttribute("")
		public Model movieChart(Model model){
			logger.info("MovieController : movieChart()진입");
			List<MovieVO> list = service.getList();
			model.addAttribute("movieList2", list);
			return model;
		}
}
