package io.acellab.service.web.startline.Status;

public enum Status {
	
	//Normal State
	RESULT_FOUND (200, "Query results found!"),
	NEW_DATA_CREATED(201, "New data successfully created!"),
	DATA_UPDATED(202, "Data updated successfully!"),
	DATA_DELETED(203, "Data removed successfully!"),
	
	//General Error
	NO_RESULT_FOUND_ERROR (404, "Query results not found..."),
	UNEXPECTED_ERROR (405, "Uh oh, something went wrong, unable to provide results at the moment..."),
	
	//User Related Error
	EXISTING_USERNAME(99, "A user with identical username already exist, please choose a different username..."),
	EXISTING_EMAIL(100, "The email has been registered, please use a different email account..."),
	USER_REGISTER_INVALID_USERNAME_FORMAT(101, "Invalid username format, allows only letters, digits, and underscore!"),
	USER_REGISTER_INVALID_PASSWORD_FORMAT(102, "Invalid password format, password should satisfy: \n"
			+ "At least one uppercase letter\n"
			+ "At least one lowercase letter\n"
			+ "At least one special character from the set @$!%*?&#<>\n"
			+ "At least one digit\n"
			+ "At least 12 characters long"),
	USER_REGISTER_INVALID_EMAIL_FORMAT(103, "Invalid email format, please verify your input!"),
	USER_ACCOUNT_UPDATE_INVALID_INPUT_FORMAT(104, "Invalid input format, allows only letters(support multiple language) and whitespaces for firstname, lastname, department, and role!"),
	SECURITY_REGISTERED_USER_NOT_FOUND(105, "We cannot find your account information, please contact us immediately if this is an error with error code 105!"),
	SECURITY_INVALID_PLANNAME(106, "We cannot process your payment, please contact us immediately for support with error code 106!"),
	
	//Company Related Error
	COMPANY_SEARCH_INVALID_INPUT(704, "Invalid input format, allows only letters(support multiple language), digits, and spaces for company name or keywords!"),
	SECURITY_INVALID_OPERATION_CREATE_BOOKMARK_INVLAID_ID(705, "Unable to add company to bookmark, failed to get the company information, please try again..."),
	SECURITY_INVALID_OPERATION_CREATE_BOOKMARK_NOT_CURRENT_USER(706, "This seems to be a prohibited operation, please try again or contact us for support..."),
	
	//Startup and Corporate Related Common Error
	UPDATE_ORG_INVALID_ORG_NAME_FORMAT(804, "Invalid company name format, allows only letters(support multiple language) and whitespaces!"),
	UPDATE_ORG_INVALID_ORG_PHONE_FORMAT(805, "Invalid phone number format, allows only digits!"),
	UPDATE_ORG_INVALID_ORG_SIZE_FORMAT(806, "Invalid company size format, allows only digits and hyphens!"),
	
	UPDATE_ORG_INVALID_PRODUCT_NAME_FORMAT(807, "Invalid product name format, allows only letters(support multiple language), digits, and whitespaces!"),
	
	UPDATE_ORG_INVALID_FUNDING_AMOUNT_FORMAT(808, "Invalid funding amount format, allows only letters(support multiple language), digits, and whitespaces!"),
	UPDATE_ORG_INVALID_INVESTORS_FORMAT(809, "Invalid product name format, allows only letters(support multiple language), commas, and whitespaces!"),
	
	UPDATE_ORG_INVALID_MEMBER_NAME_FORMAT(810, "Invalid team member name format, allows only letters(support multiple language) and whitespaces!"),
	UPDATE_ORG_INVALID_MEMBER_DEPT_FORMAT(811, "Invalid department name format, allows only letters(support multiple language) and whitespaces!"),
	UPDATE_ORG_INVALID_MEMBER_POS_FORMAT(812, "Invalid team member position format, allows only letters(support multiple language), digits, and whitespaces!"),
	UPDATE_ORG_INVALID_MEMBER_PHONE_FORMAT(813, "Invalid team member phone number format, allows only digits!"),
	
	SECURITY_INVALID_OPERATION_UPDATE_ORG_NOT_CURRENT_USER(814, "This seems to be a prohibited operation, please try again or contact us for support..."),
	
	
	//Corporate Related Error
	INVITE_COLLABORATORS_NO_COLLAB_GROUP_INFO_FOR_USER(904, "Failed to fetch your collaborators information, you won't be able to invite users/update your account collaborators at the moment, please contact us for support!"),
	INVITE_COLLABORATORS_OUT_OF_SEATS(905, "You ran out of seats for collaborators! Please contact us if this is an error or if you need any further customized support."),
	UPDATE_COLLABORATORS_USER_NOT_ADMIN(906, "This seems to be a prohibited operation, users are not allowed to update collaborators info unless user has admin role in the team!"),
	UPDATE_COLLABORATORS_USER_NOT_FOUND(907, "This seems to be an unexpected error, failed to find target user!");

	private int status_code;
	private String status_message;

	Status(int status_code, String status_message) {
		this.status_code = status_code;
		this.status_message = status_message;
	}
	
	
	//Example access: Status.ERROR.getStatusCode()
  	//Reference: https://stackoverflow.com/questions/24529739/tuple-enum-in-java
	public int getStatusCode() {return this.status_code;}
	public String getStatusMessage() {return this.status_message;}

}