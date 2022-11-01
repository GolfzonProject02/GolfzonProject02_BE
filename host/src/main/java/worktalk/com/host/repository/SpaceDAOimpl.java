package worktalk.com.host.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import worktalk.com.host.domain.Space;

@Repository
public class SpaceDAOimpl implements SpaceDAO {
	private static final Logger logger = LoggerFactory.getLogger(SpaceDAOimpl.class);

	@Autowired
	SqlSession sqlSession;

	public SpaceDAOimpl() {
		logger.info("SpaceDAOimpl()....");
	}

	@Override
	public int insert(Space space) {
		logger.info("insert()....");
		logger.info("{}", space);
		int flag = sqlSession.insert("SQL_INSERT_SPACE", space);
		return flag;
	}

	@Override
	public int update(Space space) {
		logger.info("insert()....");
		logger.info("{}", space);
		int flag = sqlSession.update("SQL_UPDATE_SPACE", space);
		return flag;
	}

	@Override
	public int delete(Space space) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Space selectOne(Space space) {
		logger.info("selectOne()...");
		Space space2 = sqlSession.selectOne("SQL_SELECT_ONE_SPACE", space);
		logger.info("{}", space2);

		return space2;
	}

	@Override
	public List<Space> selectAll() {
		logger.info("selectAll()...");
		List<Space> space_list = sqlSession.selectList("SQL_SELECT_ALL_SPACE");

		return space_list;
	}

	@Override
	public List<Space> searchList(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
