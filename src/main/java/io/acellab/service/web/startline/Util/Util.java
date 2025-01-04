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
	
	public static ResponseFactory<Object> responseFormation(Status status, Object[] companyObjects) {
		ResponseFactory<Object> responseFactory = new ResponseFactory<>();
		responseFactory.setStatus(status);
		responseFactory.setReturnDataObjects(companyObjects);
		return responseFactory;
	}
	
	
	// Login/Register Checking
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
	
	
	// User Account Setting Checking
	public static Boolean isValidAccountUpdateInputFormat(String field) {
		String regex = "^[\\p{L}\\s]*$";
		return field.matches(regex);
	}
	
	
	// Startup/Corporate Update Info Checking
	public static Boolean isValidOrgUpdateNameFormat(String startupname) {
		String regex = "^[\\p{L}\\s]*$";
		return startupname.matches(regex);
	}
	
	public static Boolean isValidOrgUpdatePhoneFormat(String phone) {
		String regex = "^\\d*$";
		return phone.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateSizeFormat(String startupsize) {
		String regex = "^[\\d-]+$";
		return startupsize.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateProductNameFormat(String productname) {
		String regex = "^[\\p{L}\\p{N}\\s]*$";
		return productname.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateFundingAmountFormat(String amount) {
		String regex = "^[\\p{L}\\p{N}\\s]*$";
		return amount.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateInvestorsFormat(String investors) {
		String regex = "^[\\p{L}\\s,]*$"; // allows comma
		return investors.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateMemberNameFormat(String name) {
		String regex = "^[\\p{L}\\s]*$";
		return name.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateMemberDeptFormat(String dept) {
		String regex = "^[\\p{L}\\s]*$";
		return dept.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateMemberPosFormat(String pos) {
		String regex = "^[\\p{L}\\p{N}\\s]*$";
		return pos.matches(regex);
	}
	
	public static Boolean isValidOrgUpdateMemberPhoneFormat(String phone) {
		String regex = "^\\d*$";
		return phone.matches(regex);
	}
	
	
	// Company Search Checking
	public static Boolean isValidSearchInput(String input) {
		String regex = "^[\\p{L}\\p{N}\\s]*$";
		return input.matches(regex);
	}

}
