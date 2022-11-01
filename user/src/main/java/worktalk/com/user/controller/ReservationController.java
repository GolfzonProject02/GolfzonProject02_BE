package worktalk.com.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import worktalk.com.user.domain.Reservation;
import worktalk.com.user.service.ReservationServiceDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	HttpSession session;
	@Autowired
	ReservationServiceDAO reserveServiceDAO;
	
	/**
	 * Making reservation
	 */
	@RequestMapping(value = {"/reservation/reserve.do"}, method = RequestMethod.POST)
	public String reserve(Reservation reservation) {
		logger.info("Welcome reserve.do!");
		logger.info("reservation: {}", reservation);
		
		Reservation result = reserveServiceDAO.reserve(reservation);
		logger.info("result: {}", result);
		
		return "home";
	}
	
	/**
	 * returns list of reservation on specific room and date
	 */
	@RequestMapping(value = {"/reservation/isBooked.do"}, method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> isBooked(Reservation reservation) {
		logger.info("Welcome isBooked.do!");
		logger.info("reservation: {}", reservation);
		
		List<Reservation> list = reserveServiceDAO.isBooked(reservation);
		logger.info("result: {}, size : {}", list, list.size());
		
		return list;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/reservation/cancel.do"}, method = RequestMethod.POST)
	public String cancel(Reservation reservation) {
		logger.info("Welcome cancel.do!");
		logger.info("reservation: {}", reservation);
		
		int flag = reserveServiceDAO.cancel(reservation);
		logger.info("flag: {}", flag);
		
		return "home";
	}
	
	/**
	 * request for user specific reservation page
	 */
	@RequestMapping(value = {"reservation/findByNum.do"}, method = RequestMethod.GET)
	public String findByNum(Reservation reservation) {
		logger.info("Welcome findByNum.do!");
		logger.info("{}", reservation);
		
		Reservation result = reserveServiceDAO.findReservationByNum(reservation);
		logger.info("result: {}", result);
		return "home";
	}
	
}
