package io.acellab.official.service.web.app.startline.Service.User;

import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Dto.User.UserDto;

public interface UserService {

    public ResponseFactory<UserEntity> findByUsername(String username);

    public ResponseFactory<UserEntity> findByEmail(String email);

    public ResponseFactory<UserDto> userRegister(UserDto userDto);

    public ResponseFactory<String> passwordValidation(String password);
}