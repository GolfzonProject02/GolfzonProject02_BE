package worktalk.com.user.repository;

import java.util.List;

import worktalk.com.user.domain.Qna;

public interface QnaDAO {

	public int insert(Qna qna);

	public int update(Qna qna);

	public int delete(Qna qna);

	public List<Qna> selectAll(long space_num);

//	public List<QNA> searchList(String searchKey, String searchWord);
}