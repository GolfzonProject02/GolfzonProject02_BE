package worktalk.com.host.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import worktalk.com.host.domain.Space;
import worktalk.com.host.repository.SpaceDAO;

@Service
public class SpaceService {
	private static final Logger logger = LoggerFactory.getLogger(SpaceService.class);
	
	@Autowired
	SpaceDAO dao;
	
	public SpaceService() {
		logger.info("SpaceService()...");
	}
	
	public int insert(Space space) {
		logger.info("insert()...");
		return dao.insert(space);
	}
	
	public List<Space> selectAll() {
		logger.info("selectAll()...");
		return dao.selectAll();
	}
	
	public Space selectOne(Space space) {
		logger.info("selectOne()...");
		return dao.selectOne(space);
	}
}
