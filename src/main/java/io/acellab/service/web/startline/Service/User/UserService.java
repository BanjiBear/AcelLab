package io.acellab.service.web.startline.Service.User;

import io.acellab.service.web.startline.Entity.UserInfo;
import io.acellab.service.web.startline.Status.ResponseFactory;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
		
	public <T> ResponseFactory<T> createNewUser(UserInfo userInfo);
	
	public <T> ResponseFactory<T> updateUser(UserInfo oldUser, UserInfo newUser);

	public <T> ResponseFactory<T> setNewUserPlanAfterPayment(UserInfo userInfo, String plan);

	//public <T> ResponseFactory<T> userLoginUponSuccessRegistration(UserInfo userInfo, HttpServletRequest request);
	
}
