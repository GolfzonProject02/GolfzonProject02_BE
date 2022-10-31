package worktalk.com.host.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import worktalk.com.host.domain.Space;
import worktalk.com.host.service.SpaceService;
import worktalk.com.host.service.SpaceServiceMultipart;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BackofficeController {
	
	private static final Logger logger = LoggerFactory.getLogger(BackofficeController.class);
	
	@Autowired
	SpaceService service;

	// 공간이미지를 받아오는 service
	@Autowired
	SpaceServiceMultipart service_file;
	
	//공간전체목록페이지
	@RequestMapping(value = "/backoffice/space_selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		logger.info("Welcome selectAll!");
		
		List<Space> space_list = service.selectAll();
		logger.info("space_list.size() : {}", space_list.size());
		
		model.addAttribute("space_list",space_list);
		
		return "backoffice/space/space_selectAll";
	}
	
	//공간상세페이지
		@RequestMapping(value = "/backoffice/space_selectOne.do", method = RequestMethod.GET)
		public String selectOne(Space space, Model model) {
			logger.info("Welcome selectOne!");
			
			Space space2 = service.selectOne(space);
			
			logger.info("{}", space2);
			model.addAttribute("space2", space2);			
			
			return "backoffice/space/space_selectOne";
		}
	
	//공간등록 페이지로 이동
	@RequestMapping(value = "/backoffice/space_insert.do", method = RequestMethod.GET)
	public String insert() {
		logger.info("Welcome insert!");
		
		return "backoffice/space/space_insert";
	}
	
	//공간등록 요청페이지
	@RequestMapping(value = "/backoffice/space_insertOK.do", method = RequestMethod.POST)
	public String insertOK(Space space) {
		logger.info("Welcome insertOK...");
		logger.info("{}", space);
		//공간이미지 가져오기
		space = service_file.getVO(space);
		//이미지 외 정보들 입력
		int result = service.insert(space);
		logger.info("result : {}", result);
		if (result == 1) {
			return "redirect:space_selectAll.do";
		} else {
			return "redirect:space_insert.do";
		}
	}
	
}
