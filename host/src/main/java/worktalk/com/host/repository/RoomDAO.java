package worktalk.com.host.repository;

import java.util.List;

import worktalk.com.host.domain.Room;

public interface RoomDAO {
	public int insert(Room room);
	public int update(Room room);
	public int delete(Room room);
	public Room selectOne(Room room);
	public List<Room> selectAll();
}
