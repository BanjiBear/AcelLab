package io.acellab.official.service.web.app.startline.Dto.User;

public class UserDto {

    private String username;
    private String password;


    public UserDto(String username, String password, String fullname) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}