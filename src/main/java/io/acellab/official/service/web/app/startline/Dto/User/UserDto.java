package io.acellab.official.service.web.app.startline.Dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String username;
    private String password;


    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;

    }

}