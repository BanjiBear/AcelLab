package io.acellab.official.service.web.app.startline.Status;

public enum Status {

    //Request Formation
    DATA_WRONG_REQUEST_FORMAT(100, "DATA_WRONG_REQUEST_FORMAT"),

    //DATA Operation (Delete , Update , Create)
    DATA_DELETED(200, "DATA_DELETED"),
    DATA_UPDATED(201, "DATA_UPDATED"),
    DATA_CREATED(202, "DATA_CREATED"),

    //For Select Operation,
    DATA_NOT_FOUND(300, "DATA_NOT_FOUND"),
    DATA_ID_EXIST(301, "DATA_ID_EXIST"),
    DATA_UNIQUE_EXIST(302, "DATA_EXIST"),
    DATA_FOUND(304, "DATA_FOUND"),

    //Error Handling & Test Message
    UNEXPECTED_ERROR (400, "UNEXPECTED_ERROR"),
    TESTING(401, "TESTING_MESSAGE"),

    //User Status
    USER_INVALID_OLD_PASSWORD(500, "USER_INVALID_OLD_PASSWORD"),
    USER_AUTHENTICATION_FAIL(501, "USER_AUTHENTICATION_FAIL"),
    USER_INVALID_PASSWORD_FORMAT(502, "USER_INVALID_PASSWORD_FORMAT"),
    USER_VALID_PASSWORD_FORMAT(503, "USER_VALID_PASSWORD_FORMAT"),

    //Company Status
    COMPANY_MEMBER_NOT_FOUND(600, "COMPANY_MEMBER_NOT_FOUND");

    private int status_code;
    private String status_message;

    Status(int status_code, String status_message) {
        this.status_code = status_code;
        this.status_message = status_message;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public String getStatusMessage() {
        return this.status_message;
    }

}