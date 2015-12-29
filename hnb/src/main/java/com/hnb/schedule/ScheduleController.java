package com.hnb.schedule;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.ticket.TicketService;
import com.hnb.ticket.TicketServiceImpl;
import com.hnb.ticket.TicketVO;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	@Autowired ScheduleServiceImpl scheduleService;
	@Autowired TicketServiceImpl ticketService;
	@Autowired ScheduleVO schedule;
	@Autowired TicketVO ticket;
	
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
			List theaterList = scheduleService.getTheaterListByMD(movie, date);
			
		} 
		else if (theater!=null && date==null) {
			logger.info("날짜널");
			List dateList = scheduleService.getShowDateListByMT(movie,theater);
		}
		else if (theater==null && date==null) {
			logger.info("다널");
			List theaterList = scheduleService.getTheaterListByM(movie);
			List dateList = scheduleService.getShowDateListByM(movie);
		}
		else if (movie!=null&&theater!=null&&date!=null) {
			List timeList = scheduleService.getTimeList(movie, theater, date);
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
			List movieListRate = scheduleService.getMovieRateByTD(theater,date);
			List movieListAsc = scheduleService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			List dateList = scheduleService.getShowDateListByMT(movie, theater);
		} else if (movie==null && date==null) {
			List movieListRate = scheduleService.getMovieRateByT(theater);
			List movieListAsc = scheduleService.getMovieAscByT(theater);
			List dateList = scheduleService.getShowDateListByT(theater);
		} else if (movie!=null&&theater!=null&&date!=null) {
			List timeLis = scheduleService.getTimeList(movie, theater, date);
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
			List movieListRate = scheduleService.getMovieRateByTD(theater,date);
			List movieListAsc = scheduleService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			List theaterList = scheduleService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			List movieListRate = scheduleService.getMovieRateByD(date);
			List movieListAsc = scheduleService.getMovieAscByD(date);
			List theaterList = scheduleService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			List timeList = scheduleService.getTimeList(movie, theater, date);
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
		String filmNumber = scheduleService.getFilmNumberBy(movie);
		System.out.println(filmNumber);
		schedule.setFilmNumber(filmNumber);
		schedule.setTheaterName(theater);
		ticket.setDate(date);
		schedule.setRoomName(time.split(" ")[0]);
		ticket.setStartTime(time.split(" ")[1]);
		System.out.println(schedule.getFilmNumber());
		System.out.println(schedule.getTheaterName());
		System.out.println(ticket.getDate());
		System.out.println(schedule.getRoomName());
		System.out.println(ticket.getStartTime());
		
		model.addAttribute("result", "success");
		
		return model;
	}
	@RequestMapping("/initList")
	public Model initList(Model model){
		List movieListRate = scheduleService.getRateList();
		List movieListAsc = scheduleService.getAscList();
		List theaterList = scheduleService.getTheaterList();
		List dateList = scheduleService.getShowDateList();
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
		model.addAttribute("time", ticket.getStartTime());
		return model;
	}
	@RequestMapping("/initSeats")
	public Model initSeats(Model model){
		System.out.println("좌석초기화진입");
		List seatList = ticketService.getSeatList(ticket.getTheaterName(),ticket.getRoomName());
		model.addAttribute("initSeats", seatList);
		return model;
	}
	@RequestMapping("/infoSave")
	public Model infoSave(Model model, String adult, String old_man, String teenager, String price, String seat_number){
		ticket.setAdult(Integer.parseInt(adult));
		ticket.setOldMan(Integer.parseInt(old_man));
		ticket.setTeenager(Integer.parseInt(teenager));
		ticket.setPrice(Integer.parseInt(price));
		ticket.setSeatNumber(seat_number);
		System.out.println(adult);
		System.out.println(old_man);
		System.out.println(teenager);
		System.out.println(price);
		System.out.println(seat_number);
		model.addAttribute("result", "success");
		return model;
	}
	@RequestMapping("/TiConfirmcket")
	public Model Confirm(Model model, String movie, String Schedule){
		model.addAttribute("movie", movie);
		model.addAttribute("ticket", ticket);
		return model;
	}
	
}
