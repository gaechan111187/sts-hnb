package com.hnb.ticket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired TicketServiceImpl ticketService;
	@Autowired TicketVO ticketVO;
	
	@RequestMapping("/initSeats")
	public Model initSeats(Model model){
		System.out.println("좌석초기화진입");
		List<?> seatList = ticketService.getSeatList(ticketVO.getTheaterName(),ticketVO.getRoomName());
		model.addAttribute("initSeats", seatList);
		return model;
	}
	
	
}
