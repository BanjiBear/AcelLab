package io.acellab.service.web.startline.Util;


import java.util.List;

import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;

public class Util {

	public static <T> ResponseFactory<T> responseFormation(Status status, List<T> resultList) {
		ResponseFactory<T> responseFactory = new ResponseFactory<>();
		responseFactory.setStatus(status);
		responseFactory.setreturnDataList(resultList);
		return responseFactory;
	}
	
	public static boolean isValidPassword(String password) {
		String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$";
		//Minimum 12 letters
		//At least one Upper
		//At least one special
		return password.matches(passwordRegex);
	}

}
