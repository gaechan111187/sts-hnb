package com.hnb.ticket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.movie.MovieController;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	@Autowired
	TicketServiceImpl ticketService;
	@Autowired
	TicketVO ticketVO;
	List movieListRate = new ArrayList();
	List movieListAsc = new ArrayList();
	List theaterList = new ArrayList();
	List dateList = new ArrayList();
	List timeList = new ArrayList();
	List seatList = new ArrayList();
	
	@RequestMapping("/Ticket")
	public String ticket(){
		return "/ticket/Ticket";
	}
	@RequestMapping("/movieSelect")
	public Model movieSelect(Model model, String movie, String theater, String date){
		if (theater == null && date!=null) {
			logger.info("극장 널");
			List theaterList = ticketService.getTheaterListByMD(movie, date);
			
		} 
		else if (theater!=null && date==null) {
			logger.info("날짜널");
			List dateList = ticketService.getShowDateListByMT(movie,theater);
		}
		else if (theater==null && date==null) {
			logger.info("다널");
			List theaterList = ticketService.getTheaterListByM(movie);
			List dateList = ticketService.getShowDateListByM(movie);
		}
		else if (movie!=null&&theater!=null&&date!=null) {
			List timeList = ticketService.getTimeList(movie, theater, date);
		}
		List movieSelectList = new ArrayList();
		logger.info("극장" +theaterList);
		logger.info("날짜" +dateList);
		movieSelectList.add(theaterList);
		movieSelectList.add(dateList);
		movieSelectList.add(timeList);
		model.addAttribute("movieCheckedList", movieSelectList);
		
		return model;
	}
	@RequestMapping("/theaterSelect")
	public Model theaterSelect(Model model, String movie, String theater, String date){
		if (movie==null && date!=null) {
			List movieListRate = ticketService.getMovieRateByTD(theater,date);
			List movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			List dateList = ticketService.getShowDateListByMT(movie, theater);
		} else if (movie==null && date==null) {
			List movieListRate = ticketService.getMovieRateByT(theater);
			List movieListAsc = ticketService.getMovieAscByT(theater);
			List dateList = ticketService.getShowDateListByT(theater);
		} else if (movie!=null&&theater!=null&&date!=null) {
			List timeLis = ticketService.getTimeList(movie, theater, date);
		}
		List theaterSelectList = new ArrayList();
		theaterSelectList.add(movieListRate);
		theaterSelectList.add(movieListAsc);
		theaterSelectList.add(dateList);
		theaterSelectList.add(timeList);
		model.addAttribute("theaterCheckedList", theaterSelectList);
		return model;
	}
	@RequestMapping("/dateSelect")
	public Model dateSelect(Model model, String movie, String theater, String date){
		if (movie==null && theater!=null) {
			List movieListRate = ticketService.getMovieRateByTD(theater,date);
			List movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			List theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			List movieListRate = ticketService.getMovieRateByD(date);
			List movieListAsc = ticketService.getMovieAscByD(date);
			List theaterList = ticketService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			List timeList = ticketService.getTimeList(movie, theater, date);
		}
		List dateSelectList = new ArrayList();
		dateSelectList.add(movieListRate);
		dateSelectList.add(movieListAsc);
		dateSelectList.add(theaterList);
		dateSelectList.add(timeList);
		System.out.println(timeList);
		model.addAttribute("dateCheckedList", dateSelectList);
		return model;
	}
	@RequestMapping("/choiceseat")
	public Model choiceseat(Model model, String movie, String theater, String date, String time){
		String filmNumber = ticketService.getFilmNumberBy(movie);
		System.out.println(filmNumber);
		ticketVO.setFilmNumber(filmNumber);
		ticketVO.setTheaterName(theater);
		ticketVO.setDate(date);
		ticketVO.setRoomName(time.split(" ")[0]);
		ticketVO.setStartTime(time.split(" ")[1]);
		System.out.println(ticketVO.getFilmNumber());
		System.out.println(ticketVO.getTheaterName());
		System.out.println(ticketVO.getDate());
		System.out.println(ticketVO.getRoomName());
		System.out.println(ticketVO.getStartTime());
		
		model.addAttribute("result", "success");
		
		return model;
	}
	@RequestMapping("/initList")
	public Model initList(Model model){
		List movieListRate = ticketService.getRateList();
		List movieListAsc = ticketService.getAscList();
		List theaterList = ticketService.getTheaterList();
		List dateList = ticketService.getShowDateList();
		List initList = new ArrayList();
		initList.add(movieListAsc);
		initList.add(movieListAsc);
		initList.add(theaterList);
		initList.add(dateList);
		System.out.println("리스트"+initList);
		model.addAttribute("totalInitList", initList);
		return model;
	}
	@RequestMapping("/Seats")
	public Model Seats(Model model, String movie, String date, String time){
		model.addAttribute("movie", movie);
		model.addAttribute("date", date);
		model.addAttribute("time", ticketVO.getStartTime());
		return model;
	}
	@RequestMapping("/initSeats")
	public Model initSeats(Model model){
		System.out.println("좌석초기화진입");
		List seatList = ticketService.getSeatList(ticketVO.getTheaterName(),ticketVO.getRoomName());
		model.addAttribute("initSeats", seatList);
		return model;
	}
	@RequestMapping("/infoSave")
	public Model infoSave(Model model, String adult, String old_man, String teenager, String price, String seat_number){
		ticketVO.setAdult(Integer.parseInt(adult));
		ticketVO.setOldMan(Integer.parseInt(old_man));
		ticketVO.setTeenager(Integer.parseInt(teenager));
		ticketVO.setPrice(Integer.parseInt(price));
		ticketVO.setSeatNumber(seat_number);
		System.out.println(adult);
		System.out.println(old_man);
		System.out.println(teenager);
		System.out.println(price);
		System.out.println(seat_number);
		model.addAttribute("result", "success");
		return model;
	}
	@RequestMapping("/TiConfirmcket")
	public Model Confirm(Model model, String movie, String ticket){
		model.addAttribute("movie", movie);
		model.addAttribute("ticket", ticketVO);
		return model;
	}
	
}
