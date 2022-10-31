package worktalk.com.host.repository;

import java.util.List;

import worktalk.com.host.domain.Space;

public interface SpaceDAO {
	public int insert(Space space);
	public int update(String key, Space space);
	public int delete(Space space);
	public Space selectOne(Space space);
	public List<Space> selectAll();
	public List<Space> searchList(String searchKey, String searchWord);	
}
