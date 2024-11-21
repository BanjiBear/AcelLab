package io.acellab.service.web.startline.Status;

public enum Status {
	
	//Normal State
	RESULT_FOUND (200, "Query results found!"),
	NEW_DATA_CREATED(201, ""),
	DATA_UPDATED(202, ""),
	DATA_DELETED(203, ""),
	
	//General Error
	ERROR (404, "No query records or results found! Please verify the submitted information"),
	INVALID_INPUT_FORMAT(405, ""),
	OUT_OF_QUOTA_ERROR(406, ""),
	UNEXPECTED_ERROR (407, "Unexpected Error Occur, currently cannot provide any results!"),
	
	//User Related Error
	EXISTING_USERNAME(99, ""),
	EXISTING_EMAIL(100, ""),
	USER_REGISTER_INVALID_USERNAME_FORMAT(101, ""),
	USER_REGISTER_INVALID_PASSWORD_FORMAT(102, ""),
	USER_REGISTER_INVALID_EMAIL_FORMAT(103, "");
	
	//Company Related Error
	//...

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