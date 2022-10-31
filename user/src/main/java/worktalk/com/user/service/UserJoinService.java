package worktalk.com.user.service;

import worktalk.com.user.domain.User;

public interface UserJoinService {
	
	public int join(User user);
	public int checkDuplicatedName(User user);

}
