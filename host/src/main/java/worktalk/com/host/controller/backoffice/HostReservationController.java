package worktalk.com.host.controller.backoffice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import worktalk.com.host.domain.Reservation;
import worktalk.com.host.domain.Reservation_status;
import worktalk.com.host.service.ReservationService;

/**
 * author: Juhee Fred Lee (이주희)
 * controller class for join functions (join, checkDuplicated, mailCheck)
 */
@Controller
public class HostReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(HostReservationController.class);
	
	@Autowired
	HttpSession session;
	@Autowired
	ReservationService service;
	
	/**
	 * Requesting for host home page
	 * @return home.jsp
	 */
	
	@RequestMapping(value = "/backoffice/reservation/findByName.do", method = RequestMethod.GET)
	public String findByName(Reservation reservation, Model model) {
		logger.info("Welcome findByName!");
		
		reservation.setName((String) session.getAttribute("host_name"));
		
		logger.info("{}", reservation);
		
		List<Reservation> reservation_list =  service.findReservationByName(reservation);
		logger.info("reservation_list : {}",reservation_list);
		
		model.addAttribute("reservation_list", reservation_list);
		
		return "home";
	}
	
	@RequestMapping(value = "/backoffice/reservation/findByStatus.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> findByStatus(Reservation reservation) {
		logger.info("Welcome findByStatus!");
		
		reservation.setName((String) session.getAttribute("host_name"));
		
		logger.info("{}", reservation);
		
		List<Reservation> reservation_list_status =  service.findReservationByKeywords(reservation);
		logger.info("reservation_list_status : {}",reservation_list_status);
		
		
		return reservation_list_status;
	}
	
	@RequestMapping(value = "/backoffice/reservation/end.do", method = RequestMethod.GET)
	@ResponseBody
	public Reservation end(Reservation reservation) {
		logger.info("Welcome end!");
		
		reservation.setStatus(Reservation_status.End.toString());
		Reservation end_result = service.updateStatus(reservation);
		logger.info("{}", end_result);

		
		return end_result;
	}
	
	
	@RequestMapping(value = "/backoffice/reservation/cancel.do", method = RequestMethod.POST)
	@ResponseBody
	public Reservation cancel(Reservation reservation) {
		logger.info("Welcome cancel!");
		logger.info("{}", reservation);
		
		Reservation cancel_result = service.cancel(reservation);
		logger.info("{}", cancel_result);

		
		return cancel_result;
	}
	
	
}
