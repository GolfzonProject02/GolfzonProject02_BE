package worktalk.com.host.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import worktalk.com.host.domain.Host;
import worktalk.com.host.repository.HostLoginDAO;

@Service
public class HostLoginServiceDAOimpl implements HostLoginService{
	
	private static final Logger logger = LoggerFactory.getLogger(HostLoginServiceDAOimpl.class);
	
	@Autowired
	HostLoginDAO loginDao;
	
	public HostLoginServiceDAOimpl() {
		logger.info("UserLogInServiceDAOimpl()....");
	}

	@Override
	public Host login(Host host) {
		logger.info("UserLogInServiceDAOimpl()....");
		return loginDao.logIn(host);
	}

}
