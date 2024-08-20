package io.acellab.official.service.web.app.startline.Status;

public enum Status {

    //Request Formation
    DATA_WRONG_REQUEST_FORMAT(1, "DATA_WRONG_REQUEST_FORMAT"),

    //DATA Operation (Delete , Update , Create)
    DATA_DELETED(2, "DATA_DELETED"),
    DATA_UPDATED(3, "DATA_UPDATED"),
    DATA_CREATED(4, "DATA_CREATED"),

    //For Select Operation,
    DATA_NOT_FOUND(5, "DATA_NOT_FOUND"),
    DATA_ID_EXIST(6, "DATA_ID_EXIST"),
    DATA_UNIQUE_EXIST(7, "DATA_EXIST"),
    DATA_FOUND(8, "DATA_FOUND"),

    //Error Handling & Test Message
    UNEXPECTED_ERROR (9, "UNEXPECTED_ERROR"),
    TESTING(10, "TESTING_MESSAGE"),

    //User Status
    USER_INVALID_OLD_PASSWORD(11, "USER_INVALID_OLD_PASSWORD"),
    USER_AUTHENTICATION_FAIL(12, "USER_AUTHENTICATION_FAIL"),
    USER_INVALID_PASSWORD_FORMAT(13, "USER_INVALID_PASSWORD_FORMAT"),
    USER_VALID_PASSWORD_FORMAT(14, "USER_VALID_PASSWORD_FORMAT");

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