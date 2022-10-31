package worktalk.com.host.service;

import worktalk.com.host.domain.Host;

public interface HostJoinService {
	
	public int join(Host host);
	public int checkDuplicatedName(Host host);

}
