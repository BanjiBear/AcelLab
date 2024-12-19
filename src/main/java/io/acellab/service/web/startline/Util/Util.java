package io.acellab.service.web.startline.Util;


import java.util.List;


import io.acellab.service.web.startline.Status.ResponseFactory;
import io.acellab.service.web.startline.Status.Status;

public class Util {

	public static <T> ResponseFactory<T> responseFormation(Status status, List<T> resultList) {
		ResponseFactory<T> responseFactory = new ResponseFactory<>();
		responseFactory.setStatus(status);
		responseFactory.setReturnDataList(resultList);
		return responseFactory;
	}
	
	public static <T> ResponseFactory<T> responseFormation(Status status) {
		ResponseFactory<T> responseFactory = new ResponseFactory<>();
		responseFactory.setStatus(status);
		return responseFactory;
	}
	
	public static Boolean isValidUsername(String username) {
		String regex = "^(?![_\\d])[A-Za-z0-9_]{5,50}$";
		return username.matches(regex);
	}
	
	public static Boolean isValidPassword(String password) {
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@$!%*?&#<>])(?=.*[0-9])[A-Za-z0-9@$!%*?&#<>]{12,}$";
		return password.matches(regex);
	}
	
	public static Boolean isValidEmailFormat(String email) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(regex);
	}
	
	public static Boolean isValidSearchInput(String input) {
		String regex = "^[\\p{L}\\p{N}\\s]*$";
		return input.matches(regex);
	}

}
