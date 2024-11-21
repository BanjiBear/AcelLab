package io.acellab.service.web.startline.Service.User;

import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Status.ResponseFactory;

public interface UserService {
		
	public <T> ResponseFactory<T> createNewUser(UserInfo userInfo);
	
}
