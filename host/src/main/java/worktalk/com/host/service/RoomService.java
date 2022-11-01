package worktalk.com.host.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import worktalk.com.host.domain.Room;
import worktalk.com.host.repository.RoomDAO;

@Service
public class RoomService {
	private static final Logger logger = LoggerFactory.getLogger(RoomService.class);
	
	@Autowired
	RoomDAO dao;
	
	public RoomService() {
		logger.info("RoomService()...");
	}
	
	public int insert(Room room) {
		logger.info("insert()...");
		return dao.insert(room);
	}
	
	public int update(Room room) {
		logger.info("update()...");
		return dao.update(room);
	}
	
	public int delete(Room room) {
		logger.info("delete()...");
		return dao.delete(room);
	}
	
	public List<Room> selectAll() {
		logger.info("selectAll()...");
		return dao.selectAll();
	}
	
	public Room selectOne(Room room) {
		logger.info("selectOne()...");
		return dao.selectOne(room);
	}
}
